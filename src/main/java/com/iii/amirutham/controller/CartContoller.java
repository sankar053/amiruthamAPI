/**
 * 
 */
package com.iii.amirutham.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.dto.model.CartDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.service.CartService;
import com.iii.amirutham.service.UserService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping("/cart")
public class CartContoller {

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;
	
	@Autowired
	private MessageSource messages;

	@PostMapping
	public ResponseEntity<CartDto> savelocalCart(HttpServletRequest request,@Valid @RequestBody CartRequest cartRequest) {

		UserDetailsImpl user = userService.getUserDetails();
		CartDto cart = null;
		CartDto pendingcart = cartService.getMyCart(user.getId());
		if(null==pendingcart)
			cart = cartService.addMyLocalCart(cartRequest);
		else
			throw new UserNotFoundException(messages.getMessage("cart.message.AlreadyExists", null, request.getLocale()));

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

	@PutMapping
	public ResponseEntity<CartDto> updatelocalCart(HttpServletRequest request,@Valid @RequestBody CartRequest cartRequest) {

		CartDto cart = cartService.updateMyLocalCart(cartRequest);
		if(null == cart)
				throw new UserNotFoundException(messages.getMessage("cart.message.NotExists", null, request.getLocale()));

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

	@GetMapping
	public ResponseEntity<CartDto> savelgetMyCart(HttpServletRequest request) {

		UserDetailsImpl user = userService.getUserDetails();

		CartDto cart = cartService.getMyCart(user.getId());
		if(null == cart)
			throw new UserNotFoundException(messages.getMessage("cart.message.NotExists", null, request.getLocale()));
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

}
