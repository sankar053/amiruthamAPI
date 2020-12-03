package com.iii.amirutham.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.ProductDto;

public interface ProductService {
	
	public void createProduct(ProductDto products,MultipartFile files[]);
	
	public void createProduct(String products,List<MultipartFile> files);
	


}
