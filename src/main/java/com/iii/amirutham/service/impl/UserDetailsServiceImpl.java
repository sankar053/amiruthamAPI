package com.iii.amirutham.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.model.user.User;
import com.iii.amirutham.repo.UserRepository;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
	
	@Autowired
	UserRepository userRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		/*User user = userRepository.findByPhoneNbr(username)
				.orElseThrow(() -> new UsernameNotFoundException("User Not Found with username: " + username));
		*/
		Optional<User> user = userRepository.findByPhoneNbr(username);
		
		if(user.isPresent()) {
			return UserDetailsImpl.build(user.get());
		}else {
			user = userRepository.findByEmailAddress(username);
			return UserDetailsImpl.build(user.get());
		}
				

		
	}

}
