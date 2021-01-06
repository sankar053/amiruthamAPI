package com.iii.amirutham.service;

import java.util.List;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.base.CategoryRequest;
import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.model.product.AmiruthamCategory;

public interface CategoryService {

	public void createBulkCategory(CategoryRequest categoryRequest,MultipartFile files) ;

	public AmiruthamCategory createCategory(String products, MultipartFile files); 

	public List<CategoryDto> findAllCatogry();

	public List<AmiruthamCategory> findAllCatogrydao();
	
	public Resource loadBannerAsResource(String fileName, String catCode);

	public CategoryDto findCatogryById(int id);

	public void deleteCatogry(int id);

	AmiruthamCategory updateCategory( CategoryDto categories) ;

	public void createBulkCategory(@Valid @NotNull @NotBlank MultipartFile files);

}
