/**
 * 
 */
package com.iii.amirutham.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
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
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<Orders> getOrdersById(@PathVariable(required = true) Integer id) {

		Orders orderDao = orderService.getOrdersById(id);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(orderDao);

	}
	@GetMapping(value ="/{id}/{status}")
	@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<GenericResponse>  updateOrderprocess(HttpServletRequest request,@PathVariable(required = true) Integer id,@PathVariable(required = true) OrderStatus status) {

		orderService.updateOrderprocess(id,status);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse("Order status got updated Successfully"));
		
	}
	
	@GetMapping(value ="invoice/{id}",produces = MediaType.APPLICATION_PDF_VALUE)
	//@PreAuthorize("hasRole('USER') or hasRole('MODERATOR') or hasRole('ADMIN')")
	public ResponseEntity<InputStreamResource>  getOrderInvoice(HttpServletRequest request,
			@PathVariable(required = true) Integer id) {

		Orders reportData =orderService.getOrdersById(id);
		File invoice =orderService.getOrderInvoice(reportData);
		InputStream targetStream = null;
		try {
			targetStream = new FileInputStream(invoice);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		//return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(messages.getMessage("order.message.success", null, request.getLocale())));
		 var headers = new HttpHeaders();
	        headers.add("Content-Disposition", "inline; filename=Invoiceport"+"-"+reportData.getOrderCode()+".pdf");
	        headers.add("Cache-Control", "no-cache, no-store, must-revalidate");
	        headers.add("Pragma", "no-cache");
	        headers.add("Expires", "0");

	        return ResponseEntity
	                .ok()
	                .headers(headers)
	                .contentLength(invoice.length())
	                .contentType(MediaType.parseMediaType("application/octet-stream"))
	                .body(new InputStreamResource(targetStream));
	}
}
