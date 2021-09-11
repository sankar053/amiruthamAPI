/**
 * 
 */
package com.iii.amirutham.service;

import java.io.File;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iii.amirutham.dto.base.OrderStatusRequest;
import com.iii.amirutham.dto.model.OrderDto;
import com.iii.amirutham.model.order.Orders;

/**
 * @author sanka
 *
 */
public interface OrderService {
	
	public String placeOrder(OrderDto order);

	public Orders getOrdersById(Integer id);

	public Page<Orders> getAllOrders(Integer pageNo, Integer pageSize,Pageable pageable);

	public void updateOrderprocess(OrderStatusRequest orderStatusReq);

	public File getOrderInvoice(Orders reportData);

}
	