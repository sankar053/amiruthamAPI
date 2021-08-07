/**
 * 
 */
package com.iii.amirutham.service;

import java.io.File;
import java.util.List;

import com.iii.amirutham.dto.base.OrderStatusRequest;
import com.iii.amirutham.dto.model.OrderDto;
import com.iii.amirutham.model.order.OrderStatus;
import com.iii.amirutham.model.order.Orders;

/**
 * @author sanka
 *
 */
public interface OrderService {
	
	public String placeOrder(OrderDto order);

	public Orders getOrdersById(Integer id);

	public List<Orders> getAllOrders();

	public void updateOrderprocess(OrderStatusRequest orderStatusReq);

	public File getOrderInvoice(Orders reportData);

}
	