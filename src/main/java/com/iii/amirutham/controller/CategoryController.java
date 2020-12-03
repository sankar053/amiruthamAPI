package com.iii.amirutham.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping("/id")
	public ResponseEntity<Object> saveCategory1(@Valid @RequestBody CategoryDto categories) {
		
		categoryService.createCategory(categories);
		return new ResponseEntity("Category Added Successfully", HttpStatus.OK);

	}
	@PostMapping
	public ResponseEntity<Object> saveCategory(@RequestPart("payload")   String categories,
			@RequestPart("file") @Valid @NotNull @NotBlank List<MultipartFile> files) {
		
		categoryService.createCategory(categories,files);
		return new ResponseEntity("Category Added Successfully", HttpStatus.OK);

	}
	
	@GetMapping
	public ResponseEntity<Object> getAllCatogry() {
		List<CategoryDto> catogList = categoryService.findAllCatogry();
System.out.println(catogList.size());
		return new ResponseEntity(catogList, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCatogryById(@PathVariable int id) {
		Optional<AmiruthamCategory> cato = categoryService.findCatogryById(id);

		return new ResponseEntity(cato.get(), HttpStatus.OK);

	}

}
