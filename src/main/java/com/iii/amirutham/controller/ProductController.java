package com.iii.amirutham.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.service.ProductService;

@RestController
@RequestMapping("/products")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping("/t")
	public ResponseEntity<Object> saveProducts(@RequestBody @Valid  ProductDto products) {
		productService.createProduct(products,null);

		return new ResponseEntity("Product Added Successfully", HttpStatus.OK);

	}
	
	@PostMapping("/{id}")
	public ResponseEntity<Object> saveProducts(@PathVariable String id,
			@RequestPart("file") @Valid @NotNull @NotBlank List<MultipartFile> files) {
		productService.createProduct(id,files);

		return new ResponseEntity("Product Added Successfully", HttpStatus.OK);

	}
	
	/*
	 * @PostMapping public ResponseEntity<Object>
	 * saveProducts(@RequestParam("payload") @Valid @RequestBody ProductDto
	 * products,
	 * 
	 * @RequestParam("file") @Valid @NotNull @NotBlank MultipartFile files[]) {
	 * productService.createProduct(products,files);
	 * 
	 * return new ResponseEntity("Product Added Successfully", HttpStatus.OK);
	 * 
	 * }
	 */



}
