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
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.ProductReviewDto;
import com.iii.amirutham.model.product.ProductReviews;
import com.iii.amirutham.service.ProductReviewService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping("/product/review")
public class ProductReviewController {
	

	@Autowired
	private MessageSource messages;
	
	@Autowired
	private ProductReviewService revivewService;
	
	@PostMapping
	public  @ResponseBody ResponseEntity<GenericResponse> addReviews(HttpServletRequest request,@Valid @RequestBody ProductReviewDto reviewRequest) {
		
		revivewService.addReviewsToProduct(reviewRequest);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new GenericResponse(messages.getMessage("message.product.review.success", null, request.getLocale())));
		
	}
	
	@GetMapping("/{productId}")
	public  @ResponseBody ResponseEntity<List<ProductReviews>> getReviewsByProduct(HttpServletRequest request,@PathVariable Integer productId) {
		
		List<ProductReviews> reviews = revivewService.getReviewsByProduct(productId);
		
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(reviews);
		
	}
	
	/*
	 * @PutMapping public @ResponseBody ResponseEntity<GenericResponse>
	 * updateReviews(HttpServletRequest request,@Valid @RequestBody ProductReviewDto
	 * reviewRequest) {
	 * 
	 * revivewService.addReviewsToProduct(reviewRequest);
	 * 
	 * return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(new
	 * GenericResponse(messages.getMessage("message.product.review.success", null,
	 * request.getLocale())));
	 * 
	 * }
	 */

}
