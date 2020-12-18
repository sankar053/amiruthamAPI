/**
 * 
 */
package com.iii.amirutham.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;
import com.iii.amirutham.service.CartService;
import com.iii.amirutham.service.UserService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping
public class CartContoller {

	@Autowired
	private CartService cartService;

	@Autowired
	private UserService userService;

	@PostMapping("/user/cart")
	public ResponseEntity<Object> savelocalCart(@Valid @RequestBody CartRequest cartRequest) {

		ShoppingCart cart = cartService.addMyLocalCart(cartRequest);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

	@GetMapping("/user/cart")
	public ResponseEntity<Object> savelgetMyCart() {

		UserDetailsImpl user = userService.getUserDetails();

		ShoppingCart cart = cartService.getMyCart(user.getId());

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

}
