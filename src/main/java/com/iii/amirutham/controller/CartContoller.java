/**
 * 
 */
package com.iii.amirutham.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
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
import com.iii.amirutham.model.shoppingcart.ShoppingCart;
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
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<CartDto> savelocalCart(HttpServletRequest request,@Valid @RequestBody CartRequest cartRequest) {
		CartDto cart = null;
		
			cart = cartService.addORUpdateMyLocalCart(cartRequest);
//		else
//			throw new UserNotFoundException(messages.getMessage("cart.message.AlreadyExists", null, request.getLocale()));

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

	@PutMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<CartDto> updatelocalCart(HttpServletRequest request,@Valid @RequestBody CartRequest cartRequest) {

		CartDto cart = cartService.updateMyLocalCart(cartRequest);
		if(null == cart)
				throw new UserNotFoundException(messages.getMessage("cart.message.NotExists", null, request.getLocale()));

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public ResponseEntity<CartDto> savedgetMyCart(HttpServletRequest request) {

		UserDetailsImpl user = userService.getUserDetails();

		CartDto cart = cartService.getMyCart(user.getId());
		if(null == cart)
			throw new UserNotFoundException(messages.getMessage("cart.message.NotExists", null, request.getLocale()));
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}
	@GetMapping("/all")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<List<ShoppingCart>> savelgetAllCart(HttpServletRequest request) {

			List<ShoppingCart> carts = cartService.getAllCart();
		if(null == carts)
			throw new UserNotFoundException(messages.getMessage("cart.message.NotExists", null, request.getLocale()));
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(carts);

	}

}
