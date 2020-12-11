/**
 * 
 */
package com.iii.amirutham.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.base.ProductsVarientRequest;
import com.iii.amirutham.dto.model.ProductVarientDto;
import com.iii.amirutham.service.ProductVarientService;

/**
 * @author sanka
 *
 */
@RestController
public class VarientController {
	private final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
	@Autowired
	private ProductVarientService productVarientService;
	
	@PostMapping("product/varient")
	public ResponseEntity<Object> registerUserAccount(@Valid @RequestBody ProductsVarientRequest productVarientDto,
			final HttpServletRequest request) {
		LOGGER.debug("Adding Product Varient  information: {}", productVarientDto);

		productVarientService.addVarientInfo(productVarientDto);
		
		return new ResponseEntity<Object>(new GenericResponse("success"), HttpStatus.OK);
	}

}
