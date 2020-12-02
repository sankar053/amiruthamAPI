package com.iii.amirutham.service.impl;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.iii.amirutham.dto.model.UserDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.ERole;
import com.iii.amirutham.model.Role;
import com.iii.amirutham.model.User;
import com.iii.amirutham.model.UserAddress;
import com.iii.amirutham.repo.RoleRepository;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.service.UserService;

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
	public User createUser(UserDto userData) {
	
		if (userRepo.existsByPhoneNbr(userData.getPhoneNbr())) {
			throw new  UserNotFoundException("Error: Username is already taken!");
		}

		if (userRepo.existsByEmailAddress(userData.getEmailAddress())) {
			throw new  UserNotFoundException("Error: Email is already in use!");
		}

		// Create new user's account
		User user = new User(null,userData.getFirstName(),
				userData.getLastName(),userData.getPhoneNbr(),userData.getEmailAddress(),						
				encoder.encode(userData.getPassword()),null,null);

		Set<String> strRoles = userData.getRole();
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
		List<UserAddress> B = userData.getAddress().stream()
		        .map(addr -> new UserAddress(null,addr.getAddress1(), addr.getAddress2(),addr.getCity(),addr.getState(),addr.getPostalCopde()))
		        .collect(Collectors.toList());
		user.setAddress(B);	

		user.setRoles(roles);
		
		return userRepo.save(user);
		

	}

	@Override
	public void deleteUserById(int id) {
		 userRepo.deleteById(id);;
		// TODO Auto-generated method stub

	}

}
