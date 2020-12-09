package com.iii.amirutham.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.model.product.AmiruthamProducts;

public interface ProductService {
	
	public List<ProductDto> retriveProducts();
	public ProductDto retriveProductById(int id);
	public void deleteProductById(int id);
	public AmiruthamProducts addProductandMedia(String prodStr,List<MultipartFile> files);
	public Resource loadProductAsResource(String fileName,String catid);
	


}
