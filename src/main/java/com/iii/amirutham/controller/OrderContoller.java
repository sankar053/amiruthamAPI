/**
 * 
 */
package com.iii.amirutham.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.model.order.Order;
import com.iii.amirutham.service.OrderService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping("/placeorder")
public class OrderContoller {

	@Autowired
	private OrderService orderService;
	
	@Autowired
	private MessageSource messages;

	@PostMapping("/{cartId}")
	public ResponseEntity<GenericResponse> placeOrder(HttpServletRequest request,@PathVariable(required = true) Integer cartId) {

		orderService.placeOrder(cartId);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(messages.getMessage("order.message.success", null, request.getLocale())));
	}
	
	@GetMapping
	public ResponseEntity<List<Order>> getAllOrders() {

		List<Order> orderDaoList =orderService.getAllOrders();
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderDaoList);
		
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Order> getOrdersById(@PathVariable(required = true) Integer id) {

		Order orderDao = orderService.getOrdersById(id);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderDao);

	}

}
