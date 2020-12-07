package com.iii.amirutham.controller;

import java.util.List;
import java.util.Locale;
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
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.base.OnRegistrationCompleteEvent;
import com.iii.amirutham.dto.model.UserDto;
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
	public List<User> retriveAllUsers() {
		return userService.findAllUsers();

	}

	@GetMapping("/users/{id}")
	public User retriveUsersById(@PathVariable int id) {
		Optional<User> user = userService.findUserById(id);
		return (user.get());

	}

	// Registration
	@PostMapping("/sign-up")
	public ResponseEntity<Object> registerUserAccount(@Valid @RequestBody UserDto accountDto,
			final HttpServletRequest request) {
		LOGGER.debug("Registering user account with information: {}", accountDto);

		final User registered = userService.registerNewUserAccount(accountDto);
		userService.addUserLocation(registered, getClientIP(request));
		eventPublisher
				.publishEvent(new OnRegistrationCompleteEvent(registered, request.getLocale(), getAppUrl(request)));
		return new ResponseEntity<Object>(new GenericResponse("success"), HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {

		userService.deleteUserById(id);
		return new ResponseEntity<>("User got Deleted Succesfully", HttpStatus.OK);

	}

	@PostMapping("/user/resetPassword")
	public GenericResponse resetPassword(HttpServletRequest request,
			@RequestParam("username") String userEmailORPhone) {
		Optional<User> user = userService.findUserByEmail(userEmailORPhone);
		System.out.println(request.getLocale());
		if (null == user) {
			throw new UserNotFoundException("");
		}
		String token = UUID.randomUUID().toString();
		userService.createPasswordResetTokenForUser(user.get(), token);
		mailSender.send(constructResetTokenEmail(getAppUrl(request), request.getLocale(), token, user.get()));
		return new GenericResponse(messages.getMessage("message.resetPasswordEmail", null, request.getLocale()));
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
