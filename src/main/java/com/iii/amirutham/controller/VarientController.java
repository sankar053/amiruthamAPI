/**
 * 
 */
package com.iii.amirutham.controller;

import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.base.ProductsVarientRequest;
import com.iii.amirutham.model.product.ProductVarient;
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
	public ResponseEntity<Object> addVarient(@Valid @RequestBody ProductsVarientRequest productVarientDto,
			final HttpServletRequest request) {
		LOGGER.debug("Adding Product Varient  information: {}", productVarientDto);

		productVarientService.addVarientInfo(productVarientDto);

		return new ResponseEntity<Object>(new GenericResponse("success"), HttpStatus.OK);
	}

	@PutMapping("product/varient")
	public ResponseEntity<Object> updateVarient(@Valid @RequestBody ProductsVarientRequest productVarientDto,
			final HttpServletRequest request) {
		LOGGER.debug("Update Product Varient  information: {}", productVarientDto);

		productVarientService.updateVarientInfo(productVarientDto);

		return new ResponseEntity<Object>(new GenericResponse("success"), HttpStatus.OK);
	}

	@GetMapping("product/varient/{id}")
	public ResponseEntity<ProductVarient> getVarientById(@PathVariable String id,
			final HttpServletRequest request) {
		LOGGER.debug("Get Product Varient  By Id: {}", id);

		Optional<ProductVarient> varient = productVarientService.getVarientInfoById(id);

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(varient.get());
	}

	@GetMapping("product/varient")
	public ResponseEntity<List<ProductVarient>> deleteVarient(final HttpServletRequest request) {
		LOGGER.debug("Get All Product Varient  Info: {}");

		List<ProductVarient> varientList = productVarientService.getAllVarientInfo();

		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(varientList);
	}

	@DeleteMapping("product/varient")
	public ResponseEntity<Object> deleteVarientInfo(final HttpServletRequest request) {
		LOGGER.debug("Delete All Product Varient  information: {}");

		productVarientService.deleteVarientInfo();

		return new ResponseEntity<Object>(new GenericResponse("VarientInfo got Deleted successfully"), HttpStatus.OK);
	}

	@DeleteMapping("product/varient/{id}")
	public ResponseEntity<Object> deleteVarientById(@PathVariable String id, final HttpServletRequest request) {
		LOGGER.debug("Delete Product Varient  By Id: {}", id);

		productVarientService.deleteVarientInfoById(id);

		return new ResponseEntity<Object>(new GenericResponse("Varient Deleted successfully {} " + id), HttpStatus.OK);
	}

}
