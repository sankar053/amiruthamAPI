package com.iii.amirutham.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;
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
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		// TODO Auto-generated method stub
		/*
		 * User user = userRepository.findByPhoneNbr(username) .orElseThrow(() -> new
		 * UsernameNotFoundException("User Not Found with username: " + username));
		 */
		/*
		 * User user =userRepository.findByPhoneNbr(username) .orElse(() ->
		 * userRepository.findByPhoneNbr(username). orElseThrow(() -> new
		 * UsernameNotFoundException("User Not Found with username: " + username)));
		 */
		Optional<User> user = userRepository.findByPhoneNbr(username);
		int cartItemCount = 0;
		String isPendingCart = "false";
		if (user.isPresent()) {
			ShoppingCart myCart = cartService.getMyCart(user.get().getId());
			if (null != myCart) {
				isPendingCart="true";
				cartItemCount = myCart.getLineItems() != null ? myCart.getLineItems().size() : 0;}

			return UserDetailsImpl.build(user.get(), cartItemCount, isPendingCart);
		} else {
			user = userRepository.findByEmailAddress(username);
			ShoppingCart myCart = cartService.getMyCart(user.get().getId());
			if (null != myCart) {
				isPendingCart="true";
				cartItemCount = myCart.getLineItems() != null ? myCart.getLineItems().size() : 0;}
			
			return UserDetailsImpl.build(user.get(), cartItemCount, isPendingCart);
		}

	}

}
