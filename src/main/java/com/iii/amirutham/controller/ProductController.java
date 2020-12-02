package com.iii.amirutham.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.service.ProductService;

@RestController
@RequestMapping("/Catogory")
public class ProductController {

	@Autowired
	private ProductService productService;

	@PostMapping
	public ResponseEntity<Object> saveProducts(@Valid @RequestBody CategoryDto categories) {
		productService.createProduct(categories);

		return new ResponseEntity("Product Added Successfully", HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<Object> getAllCatogry() {
		List<CategoryDto> catogList = productService.findAllCatogry();
System.out.println(catogList.size());
		return new ResponseEntity(catogList, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCatogryById(@PathVariable int id) {
		Optional<AmiruthamCategory> cato = productService.findCatogryById(id);

		return new ResponseEntity(cato.get(), HttpStatus.OK);

	}

}
