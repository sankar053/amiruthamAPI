/**
 * 
 */
package com.iii.amirutham.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;
import com.iii.amirutham.service.CartService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping
public class CartContoller {
	
	@Autowired
	private CartService cartService;
	
	@PostMapping("/user/cart")
	public ResponseEntity<Object> savelocalCart(@Valid @RequestBody CartRequest cartRequest) {
		
		ShoppingCart cart=	cartService.addMyLocalCart(cartRequest);
		

		return  ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
               .body(cart);

	}

}
