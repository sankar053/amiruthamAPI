package com.iii.amirutham.controller;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
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

	
	
	@PostMapping
	public ResponseEntity<Object> saveProducts(@RequestPart("payload") String payload,
			@RequestPart("file") @Valid @NotNull @NotBlank List<MultipartFile> files) {
		productService.addImgToProduct(payload,files);

		return new ResponseEntity("Product Added Successfully", HttpStatus.OK);

	}
	
	@GetMapping
	public ResponseEntity<Object> retriveProducts() {
		List<ProductDto> products =productService.retriveProducts();

		return new ResponseEntity(products, HttpStatus.OK);

	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Object> retriveProducts(@PathVariable int id) {
		ProductDto product =productService.retriveProductById(id);

		return new ResponseEntity(product, HttpStatus.OK);

	}
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteProduct(@PathVariable int id) {
		productService.deleteProductById(id);

		return new ResponseEntity("Product Deleted Successfully", HttpStatus.OK);

	}
	


}
