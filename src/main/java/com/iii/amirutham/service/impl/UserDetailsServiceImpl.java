package com.iii.amirutham.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.model.CartDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.user.User;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.service.CartService;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	UserRepository userRepository;

	@Autowired
	private CartService cartService;

	@Override
	public UserDetails loadUserByUsername(String username) throws UserNotFoundException {

		Optional<User> user = userRepository.findByPhoneNbr(username);

		if (!user.isPresent()) {
			user = userRepository.findByEmailAddress(username);
			if (user.isPresent())
				return getavailableCart(user.get());
			else
				throw new UserNotFoundException("Username/Password not exists");
		} else {
			return getavailableCart(user.get());

		}

	}

	public UserDetails getavailableCart(User user) {
		CartDto myCart = cartService.getMyCart(user.getId());
		if (null != myCart)
			return UserDetailsImpl.build(user, myCart.getLineItems() != null ? myCart.getLineItems().size() : 0,
					"true");
		else
			return UserDetailsImpl.build(user, 0, "false");

	}

}
