package com.iii.amirutham.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.MessageSource;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iii.amirutham.dto.base.EmailTemplate;
import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.base.OnRegistrationCompleteEvent;
import com.iii.amirutham.dto.model.UserDto;
import com.iii.amirutham.dto.model.ValidateOtpDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.User;
import com.iii.amirutham.service.ISecurityUserService;
import com.iii.amirutham.service.UserService;

@RestController
@RequestMapping
public class UserController {

	private final Logger LOGGER = LoggerFactory.getLogger(getClass());

	@Autowired
	private UserService userService;

	@Autowired
	private MessageSource messages;

	@Autowired
	private JavaMailSender mailSender;

	@Autowired
	private Environment env;

	@Autowired
	private ApplicationEventPublisher eventPublisher;

	@Autowired
	private ISecurityUserService securityUserService;

	@GetMapping("/users")
	public @ResponseBody ResponseEntity<Object> retriveAllUsers() {
		List<User> userList = userService.findAllUsers();

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(userList);

	}

	@GetMapping("/users/{id}")
	public @ResponseBody ResponseEntity<User> retriveUsersById(@PathVariable int id) {
		Optional<User> user = userService.findUserById(id);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(user.get());

	}

	@GetMapping("/user/profile")
	public @ResponseBody ResponseEntity<UserDetails> getUserProfileInfo() {
		UserDetails user = userService.getUserDetails();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).
				body(user);

	}

	// Registration
	@PostMapping("/sign-up")
	public @ResponseBody ResponseEntity<GenericResponse> registerUserAccount(@Valid @RequestBody UserDto accountDto,
			final HttpServletRequest request) {
		LOGGER.debug("Registering user account with information: {}", accountDto);

		final User registered = userService.registerNewUserAccount(accountDto);
		userService.addUserLocation(registered, getClientIP(request));
		eventPublisher
				.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).
				body(new GenericResponse("success"));
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<GenericResponse> deleteUser(@PathVariable int id) {

		userService.deleteUserById(id);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).
				body(new GenericResponse("User got Deleted Succesfully"));

	}

	@PostMapping("/user/forgetPassword")
	public @ResponseBody GenericResponse forgetPassword(HttpServletRequest request,
			@RequestParam("username") String userEmailORPhone) {
		Optional<User> user = userService.findUserByEmail(userEmailORPhone);
		if (null == user) {
			throw new UserNotFoundException(messages.getMessage("auth.message.invalidUser", null, request.getLocale()));
		}
		String token = UUID.randomUUID().toString();
		String otp = userService.createPasswordResetTokenForUser(user.get(), token);
		constructOTPEmail(user.get(), request.getLocale(), otp);
		return new GenericResponse(messages.getMessage("message.otpEmail", null, request.getLocale()));
	}

	@PostMapping("/user/resetPassword")
	public @ResponseBody ResponseEntity<GenericResponse> resetPassword(HttpServletRequest request,
			@RequestParam("username") String userEmailORPhone) {
		Optional<User> user = userService.findUserByEmail(userEmailORPhone);

		if (null == user) {
			throw new UserNotFoundException("");
		}
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user.get(), token);
		mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user.get()));
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).
				body(new GenericResponse(messages.getMessage("message.resetPasswordEmail", null, request.getLocale())));
	}

	public void constructOTPEmail(User to, Locale locale, String otp) {

		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		String username = auth.getName();
		LOGGER.info("OTP : " + otp);

		// Generate The Template to send OTP
		EmailTemplate template = new EmailTemplate("SendOtp.html");

		Map<String, String> replacements = new HashMap<String, String>();
		replacements.put("user", username);
		replacements.put("otpnum", otp);

		String message = template.getTemplate(replacements);

		sendOtpMessage(to, "OTP -SpringBoot", message, locale);
	}

	public void sendOtpMessage(User to, String subject, String body, final Locale locale) {
		final String message = messages.getMessage("message.resetPassword", null, locale);
		mailSender.send(constructEmail(subject, body, to));

	}

	@PostMapping("/user/validateOtp")
	public @ResponseBody ResponseEntity<GenericResponse> validateOtp(@Valid @RequestBody ValidateOtpDto otpDto,
			final HttpServletRequest request) {

		final String result = securityUserService.validateOneTimePassword(otpDto.getOneTimePassword());

		if (result != null) {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).
					body(new GenericResponse(messages.getMessage("auth.message." + result, null, request.getLocale())));
		}

		boolean updated = userService.updatePassword(otpDto);
		if (updated) {

			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).
					body(new GenericResponse(messages.getMessage("message.resetPasswordSuc", null, request.getLocale())));
		} else {
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).
					body(new GenericResponse(messages.getMessage("auth.message.invalid", null, request.getLocale())));
		}

	}

	@GetMapping("/user/changePassword")
	public ModelAndView showChangePasswordPage(final ModelMap model, @RequestParam("token") final String token) {
		final String result = securityUserService.validatePasswordResetToken(token);

		if (result != null) {
			String messageKey = "auth.message." + result;
			model.addAttribute("messageKey", messageKey);
			return new ModelAndView("redirect:/login", model);
		} else {
			model.addAttribute("token", token);
			return new ModelAndView("redirect:/updatePassword");
		}
	}

	@GetMapping("/updatePassword")
	public ModelAndView updatePassword(final HttpServletRequest request, final ModelMap model,
			@RequestParam("messageKey") final Optional<String> messageKey) {
		Locale locale = request.getLocale();
		model.addAttribute("lang", locale.getLanguage());
		messageKey.ifPresent(key -> {
			String message = messages.getMessage(key, null, locale);
			model.addAttribute("message", message);
		});

		return new ModelAndView("updatePassword", model);
	}

	private String getAppUrl(HttpServletRequest request) {
		return "http://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
	}

	private SimpleMailMessage constructResetTokenEmail(final String contextPath, final Locale locale,
			final String token, final User user) {
		final String url = contextPath + "/user/changePassword?token=" + token;
		final String message = messages.getMessage("message.resetPassword", null, locale);
		return constructEmail("Reset Password", message + " \r\n" + url, user);
	}

	private SimpleMailMessage constructEmail(String subject, String body, User user) {
		final SimpleMailMessage email = new SimpleMailMessage();
		email.setSubject(subject);
		email.setText(body);
		email.setTo(user.getEmailAddress());
		email.setFrom(env.getProperty("support.email"));
		email.setSentDate(new Date());

		return email;
	}

	private String getClientIP(HttpServletRequest request) {
		final String xfHeader = request.getHeader("X-Forwarded-For");
		if (xfHeader == null) {
			return request.getRemoteAddr();
		}
		return xfHeader.split(",")[0];
	}

}
