/**
 * 
 */
package com.iii.amirutham.service;

import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.dto.model.CartDto;
import com.iii.amirutham.exception.UserNotFoundException;

/**
 * @author sanka
 *
 */
public interface CartService {

	public CartDto addORUpdateMyLocalCart(CartRequest cartRequest);
	
	public CartDto updateMyLocalCart(CartRequest cartRequest) throws UserNotFoundException;

	public CartDto getMyCart(Integer customerId);

}
