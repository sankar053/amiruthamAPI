/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;

import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.dto.model.CartDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;

/**
 * @author sanka
 *
 */
public interface CartService {

	public CartDto addORUpdateMyLocalCart(CartRequest cartRequest);
	
	public CartDto updateMyLocalCart(CartRequest cartRequest) throws UserNotFoundException;

	public CartDto getMyCart(Integer customerId);

	public List<ShoppingCart> getAllCart();

}
