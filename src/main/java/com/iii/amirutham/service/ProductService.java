package com.iii.amirutham.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.ProductDto;

public interface ProductService {
	
	public List<ProductDto> retriveProducts();
	public ProductDto retriveProductById(int id);
	public void deleteProductById(int id);
	public GenericResponse addUpdateProductandMedia(String prodStr,List<MultipartFile> files,HttpServletRequest request);
	public Resource loadProductAsResource(String fileName,String catid);
	


}
