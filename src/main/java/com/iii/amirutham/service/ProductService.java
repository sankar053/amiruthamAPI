package com.iii.amirutham.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.ProductDto;

public interface ProductService {
	
	public List<ProductDto> retriveProducts();
	public ProductDto retriveProductById(int id);
	public void deleteProductById(int id);
	public void addImgToProduct(String prodStr,List<MultipartFile> files);
	


}
