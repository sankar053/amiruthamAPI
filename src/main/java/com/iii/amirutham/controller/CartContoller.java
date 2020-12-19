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
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.dto.model.CartDto;
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

	@PostMapping
	public ResponseEntity<Object> savelocalCart(@Valid @RequestBody CartRequest cartRequest) {

		ShoppingCart cart = cartService.addMyLocalCart(cartRequest);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}
	
	@PutMapping
	public ResponseEntity<Object> updatelocalCart(@Valid @RequestBody CartRequest cartRequest) {

		ShoppingCart cart = cartService.updateMyLocalCart(cartRequest);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

	@GetMapping
	public ResponseEntity<CartDto> savelgetMyCart() {

		UserDetailsImpl user = userService.getUserDetails();

		CartDto cart = cartService.getMyCart(user.getId());

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(cart);

	}

}
