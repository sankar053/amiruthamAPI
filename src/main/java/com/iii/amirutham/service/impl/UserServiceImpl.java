package com.iii.amirutham.service.impl;

import java.net.InetAddress;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iii.amirutham.common.EmailService;
import com.iii.amirutham.common.mail.dto.OnetimePasswordMail;
import com.iii.amirutham.common.mail.dto.OrderDataMail;
import com.iii.amirutham.common.mail.dto.OrderDeliveryDetails;
import com.iii.amirutham.common.mail.dto.OrderItemsMail;
import com.iii.amirutham.common.mail.dto.RegistationMail;
import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.model.UserDto;
import com.iii.amirutham.dto.model.ValidateOtpDto;
import com.iii.amirutham.exception.TokenExpireException;
import com.iii.amirutham.exception.UserAlreadyExistException;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.model.user.ERole;
import com.iii.amirutham.model.user.PasswordResetToken;
import com.iii.amirutham.model.user.Role;
import com.iii.amirutham.model.user.User;
import com.iii.amirutham.model.user.UserLocation;
import com.iii.amirutham.model.user.VerificationToken;
import com.iii.amirutham.repo.OrderRepository;
import com.iii.amirutham.repo.PasswordResetTokenRepository;
import com.iii.amirutham.repo.RoleRepository;
import com.iii.amirutham.repo.UserLocationRepository;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.repo.VerificationTokenRepository;
import com.iii.amirutham.service.UserService;
import com.iii.amirutham.utills.AmirthumUtills;
import com.maxmind.geoip2.DatabaseReader;

/**
 * @author sanka
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder passwordEncoder;

	@Autowired
	private Environment env;
	
	@Autowired
	private EmailService emailService;

	@Autowired
	private PasswordResetTokenRepository passwordTokenRepository;

	@Autowired
	private VerificationTokenRepository tokenRepository;

	@Autowired
	@Qualifier("GeoIPCountry")
	private DatabaseReader databaseReader;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private UserLocationRepository userLocationRepository;

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepository.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepository.findById(id);
	}

	@Override
	public UserDetailsImpl getUserDetails() {
		UserDetailsImpl userDetails = null;
		try {
			userDetails = (UserDetailsImpl) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		} catch (Exception w) {
			throw new TokenExpireException("Token Got Expired");
		}
		return userDetails;
	}

	@Override
	public User registerNewUserAccount(UserDto accountDto) {

		if (userRepository.existsByPhoneNbr(accountDto.getPhoneNbr())) {
			throw new UserAlreadyExistException(
					"There is an account with that Phone Number: " + accountDto.getPhoneNbr());
		}

		if (userRepository.existsByEmailAddress(accountDto.getEmailAddress())) {
			throw new UserAlreadyExistException(
					"There is an account with that email address: " + accountDto.getEmailAddress());		}

		// Create new user's account
		User user = new User(null, accountDto.getFirstName(), accountDto.getLastName(), accountDto.getPhoneNbr(),
				accountDto.getEmailAddress(), passwordEncoder.encode(accountDto.getPassword()), null);

		Set<String> strRoles = accountDto.getRole();
		Set<Role> roles = new HashSet<>();

		if (strRoles == null) {
			Role userRole = roleRepository.findByName(ERole.ROLE_USER)
					.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
			roles.add(userRole);
		} else {
			strRoles.forEach(role -> {
				switch (role) {
				case "admin":
					Role adminRole = roleRepository.findByName(ERole.ROLE_ADMIN)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(adminRole);

					break;
				case "mod":
					Role modRole = roleRepository.findByName(ERole.ROLE_MODERATOR)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(modRole);

					break;
				default:
					Role userRole = roleRepository.findByName(ERole.ROLE_USER)
							.orElseThrow(() -> new RuntimeException("Error: Role is not found."));
					roles.add(userRole);
				}
			});
			user.setRoles(roles);
		}
		emailService.sendTemplateEmail(user.getEmailAddress(), "Your Amirutham ePortal account has been created!", "register-template", 
				new RegistationMail(user.getFirstName(),user.getEmailAddress(),"http://localhost:4200/home")
				, null);
		return userRepository.save(user);
		
	}

	@Override
	public void deleteUserById(int id) {
		userRepository.deleteById(id);
		;
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<User> findByUserName(String userEmailORPhone) {
		// TODO Auto-generated method stub

		if (userRepository.existsByPhoneNbr(userEmailORPhone)) {
			return userRepository.findByPhoneNbr(userEmailORPhone);
		}

		if (userRepository.existsByEmailAddress(userEmailORPhone)) {
			return userRepository.findByEmailAddress(userEmailORPhone);
		}
		return null;
	}

	@Override
	public String createPasswordResetTokenForUser(User user) {
		String token = UUID.randomUUID().toString();
		String otp = AmirthumUtills.generateOTP();
		final PasswordResetToken myToken = new PasswordResetToken(token, user, otp);
		passwordTokenRepository.save(myToken);
		return otp;
	}

	@Override

	public void addUserLocation(User user, String ip) {

		/*
		 * if (!isGeoIpLibEnabled()) { return; }
		 */

		try {
			final InetAddress ipAddress = InetAddress.getByName(ip);
			System.out.println(ipAddress);
			final String country = "India";// databaseReader.country(ipAddress).getCountry().getName();
			UserLocation loc = new UserLocation(country, user);
			loc.setEnabled(true);
			userLocationRepository.save(loc);
		} catch (final Exception e) {
			throw new RuntimeException(e);
		}
	}

	private boolean isGeoIpLibEnabled() {
		System.out.println(env.getProperty("geo.ip.lib.enabled"));
		return false;// Boolean.parseBoolean(env.getProperty("geo.ip.lib.enabled"));
	}

	@Override
	public void createVerificationTokenForUser(User user, String token) {
		final VerificationToken myToken = new VerificationToken(token, user);
		tokenRepository.save(myToken);

	}

	@Override
	public boolean updatePassword(ValidateOtpDto otpDto) {

		Optional<User> user = findByUserName(otpDto.getUserName());

		if (user.isPresent()) {
			user.get().setPassword(passwordEncoder.encode(otpDto.getChangePassword()));
			userRepository.save(user.get());
			return true;
		} else {

			throw new UserNotFoundException("");
		}

	}

	@Override
	public Page<Orders> myorders(Integer pageNo, Integer pageSize, Pageable pageable) {
		// TODO Auto-generated method stub
		if (pageNo != null && pageSize != null)
			pageable = PageRequest.of(pageNo, pageSize, Sort.by(Order.desc("createdTs"), Order.desc("id")));
		UserDetailsImpl userDetails = getUserDetails();
		Optional<User> user = userRepository.findById(userDetails.getId());
		if (user.isPresent())
			return orderRepository.findByUser(user.get(), pageable);
		return null;
	}

	@Override
	public boolean checkIfValidOldPassword(UserDetailsImpl user, String oldPassword) {
		// TODO Auto-generated method stub
		return passwordEncoder.matches(oldPassword, user.getPassword());
	}

	@Override
	public void changeUserPassword(String userName, String password) {
		// TODO Auto-generated method stub
		Optional<User> user = findByUserName(userName);

		if (user.isPresent()) {
			User userDao = user.get();
			userDao.setPassword(passwordEncoder.encode(password));
			userRepository.save(userDao);
		}

	}

	@Override
	public void constructOTPEmail(User user, String otp) {
		// TODO Auto-generated method stub
		
		
		emailService.sendTemplateEmail(user.getEmailAddress(), "Password Reset Request for Amirutham eportal", "otp-template", 
					new OnetimePasswordMail(otp,user.getFirstName(),user.getEmailAddress()), null);
		
	}

}
