package com.iii.amirutham.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.base.CategoryRequest;
import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.service.CategoryService;

@RestController
@RequestMapping("/category")
public class CategoryController {

	@Autowired
	private CategoryService categoryService;

	@PostMapping
	public ResponseEntity<Object> saveCategory(@Valid @RequestBody CategoryRequest categoryRequest) {

		List<AmiruthamCategory> createdCategoryList =categoryService.createCategory(categoryRequest);
		return ResponseEntity.ok()
                .contentType(MediaType.APPLICATION_JSON)
               .body(createdCategoryList) ;

	}
	
	@PutMapping
	public ResponseEntity<Object> updateCategory(@Valid @RequestBody CategoryDto categories) {

		AmiruthamCategory updatedCategory =categoryService.updateCategory(categories);
		return new ResponseEntity(updatedCategory, HttpStatus.OK);

	}
	
	@PatchMapping
	public ResponseEntity<Object> updateCategoryPatch(@Valid @RequestBody CategoryDto categories) {

		AmiruthamCategory updatedCategory = categoryService.updateCategory(categories);
		return new ResponseEntity(updatedCategory, HttpStatus.OK);

	}

	@GetMapping
	public ResponseEntity<Object> getAllCatogry() {
		List<CategoryDto> catogList = categoryService.findAllCatogry();
		System.out.println(catogList.size());
		return new ResponseEntity(catogList, HttpStatus.OK);

	}

	@GetMapping("/{id}")
	public ResponseEntity<Object> getCatogryById(@PathVariable int id) {
		CategoryDto category = categoryService.findCatogryById(id);

		return new ResponseEntity(category, HttpStatus.OK);

	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<Object> deleteCatogryById(@PathVariable int id) {
		categoryService.deleteCatogry(id);

		return new ResponseEntity("Category Deleted Successfully", HttpStatus.OK);

	}

}
