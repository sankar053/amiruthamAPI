/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;

import com.iii.amirutham.model.order.OrderStatus;
import com.iii.amirutham.model.order.Orders;

/**
 * @author sanka
 *
 */
public interface OrderService {
	
	public void placeOrder(Integer cartId);

	public Orders getOrdersById(Integer id);

	public List<Orders> getAllOrders();

	public void updateOrderprocess(Integer id, OrderStatus status);

}
	