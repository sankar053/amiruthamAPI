package com.iii.amirutham.service;

import java.util.List;
import java.util.Optional;

import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.model.product.AmiruthamCategory;

public interface ProductService {
	
	public void createProduct(CategoryDto categories);
	
	public List<CategoryDto> findAllCatogry();
	
	public Optional<AmiruthamCategory> findCatogryById(int id);

}
