package com.iii.amirutham.service;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.base.CategoryRequest;
import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.model.product.AmiruthamCategory;

public interface CategoryService {

	public void createCategory(CategoryRequest categoryRequest) ;

	public void createCategory(String products, List<MultipartFile> files); 

	public List<CategoryDto> findAllCatogry();

	public List<AmiruthamCategory> findAllCatogrydao();

	public CategoryDto findCatogryById(int id);

	public void deleteCatogry(int id);

	AmiruthamCategory updateCategory( CategoryDto categories) ;

}
