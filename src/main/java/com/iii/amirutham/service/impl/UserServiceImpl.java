package com.iii.amirutham.service.impl;

import java.net.InetAddress;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.core.env.Environment;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iii.amirutham.dto.model.UserDto;
import com.iii.amirutham.exception.UserAlreadyExistException;
import com.iii.amirutham.model.ERole;
import com.iii.amirutham.model.PasswordResetToken;
import com.iii.amirutham.model.Role;
import com.iii.amirutham.model.User;
import com.iii.amirutham.model.UserAddress;
import com.iii.amirutham.model.UserLocation;
import com.iii.amirutham.model.VerificationToken;
import com.iii.amirutham.repo.PasswordResetTokenRepository;
import com.iii.amirutham.repo.RoleRepository;
import com.iii.amirutham.repo.UserLocationRepository;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.repo.VerificationTokenRepository;
import com.iii.amirutham.service.UserService;
import com.maxmind.geoip2.DatabaseReader;

/**
 * @author sanka
 *
 */
@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepo;

	@Autowired
	RoleRepository roleRepository;

	@Autowired
	PasswordEncoder encoder;

	@Autowired
	private Environment env;
	
	@Autowired
    private PasswordResetTokenRepository passwordTokenRepository;
	
	@Autowired
    private VerificationTokenRepository tokenRepository;

	@Autowired
	@Qualifier("GeoIPCountry")
	private DatabaseReader databaseReader;

	@Autowired
	private UserLocationRepository userLocationRepository;

	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return userRepo.findAll();
	}

	@Override
	public Optional<User> findUserById(int id) {
		// TODO Auto-generated method stub
		return userRepo.findById(id);
	}

	@Override
	public User registerNewUserAccount(UserDto accountDto) {

		if (userRepo.existsByPhoneNbr(accountDto.getPhoneNbr())) {
			throw new UserAlreadyExistException(
					"There is an account with that Phone Number: " + accountDto.getPhoneNbr());
		}

		if (userRepo.existsByEmailAddress(accountDto.getEmailAddress())) {
			throw new UserAlreadyExistException(
					"There is an account with that email address: " + accountDto.getEmailAddress());
		}

		// Create new user's account
		User user = new User(null, accountDto.getFirstName(), accountDto.getLastName(), accountDto.getPhoneNbr(),
				accountDto.getEmailAddress(), encoder.encode(accountDto.getPassword()), null, null);

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
		}
		if(null !=accountDto
				.getAddress() && accountDto
				.getAddress().size()>0) {
		List<UserAddress> addressDao = accountDto
				.getAddress().stream().map(addr -> new UserAddress(null, addr.getAddress1(), addr.getAddress2(),
						addr.getAddressType(), addr.getCity(), addr.getState(), addr.getPostalCopde()))
				.collect(Collectors.toList());
		user.setAddress(addressDao);
	}

		user.setRoles(roles);

		return userRepo.save(user);

	}

	@Override
	public void deleteUserById(int id) {
		userRepo.deleteById(id);
		;
		// TODO Auto-generated method stub

	}

	@Override
	public Optional<User> findUserByEmail(String userEmailORPhone) {
		// TODO Auto-generated method stub
		
		if (userRepo.existsByPhoneNbr(userEmailORPhone)) {
			return userRepo.findByPhoneNbr(userEmailORPhone);
		}

		if (userRepo.existsByEmailAddress(userEmailORPhone)) {
			return userRepo.findByEmailAddress(userEmailORPhone);
		}
		return null;
	}

	@Override
	public void createPasswordResetTokenForUser(User user, String token) {
		  final PasswordResetToken myToken = new PasswordResetToken(token, user);
	        passwordTokenRepository.save(myToken);
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

}
