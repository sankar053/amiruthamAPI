/**
 * 
 */
package com.iii.amirutham.service;

import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.dto.model.CartDto;

/**
 * @author sanka
 *
 */
public interface CartService {

	public CartDto addMyLocalCart(CartRequest cartRequest);
	
	public CartDto updateMyLocalCart(CartRequest cartRequest);

	public CartDto getMyCart(Integer customerId);

}
