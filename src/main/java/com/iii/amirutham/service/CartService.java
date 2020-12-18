/**
 * 
 */
package com.iii.amirutham.service;

import com.iii.amirutham.dto.base.CartRequest;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;

/**
 * @author sanka
 *
 */
public interface CartService {

	public ShoppingCart addMyLocalCart(CartRequest cartRequest);

	public ShoppingCart getMyCart(Integer customerId);

}
