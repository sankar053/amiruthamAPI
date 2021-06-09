package com.iii.amirutham.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.model.product.AmiruthamProducts;

public interface ProductService {
	
	public List<ProductDto> retriveProducts();
	public ProductDto retriveProductById(int id);
	public void deleteProductById(Integer id);
	public AmiruthamProducts addProductandMedia(ProductDto productsDto,List<MultipartFile> files,HttpServletRequest request);
	public Resource loadProductAsResource(String fileName,String catid);
	public AmiruthamProducts updateProductandMedia(ProductDto productsDto, List<MultipartFile> files,
			HttpServletRequest request);
	


}
