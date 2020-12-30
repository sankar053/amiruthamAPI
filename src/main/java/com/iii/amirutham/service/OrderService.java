/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;

import com.iii.amirutham.model.order.Order;

/**
 * @author sanka
 *
 */
public interface OrderService {
	
	public void placeOrder(Integer cartId);

	public Order getOrdersById(Integer id);

	public List<Order> getAllOrders();

}
	