/**
 * 
 */
package com.iii.amirutham.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.OrderDto;
import com.iii.amirutham.model.order.OrderStatus;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.service.OrderService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping("/order")
public class OrderContoller {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MessageSource messages;

	@PostMapping("/placeorder")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<GenericResponse> placeOrder(HttpServletRequest request,@Valid @RequestBody OrderDto order) {

		String OrderRef = orderService.placeOrder(order);
		if(null!=OrderRef)
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(messages.getMessage("order.message.success", null, request.getLocale())+OrderRef));
		else
			return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(messages.getMessage("order.message.failure", null, request.getLocale())));
			
	}
	
	@GetMapping
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<List<Orders>> getAllOrders() {

		List<Orders> orderDaoList =orderService.getAllOrders();
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderDaoList);
		
	}
	
	@GetMapping("/placeorder/{id}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Orders> getOrdersById(@PathVariable(required = true) Integer id) {

		Orders orderDao = orderService.getOrdersById(id);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderDao);

	}
	@GetMapping("/{id}/{status}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<GenericResponse> updateOrderprocess(HttpServletRequest request,@PathVariable(required = true) Integer id,@PathVariable(required = true) OrderStatus status) {

		orderService.updateOrderprocess(id,status);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(messages.getMessage("order.message.success", null, request.getLocale())));

	}
}
