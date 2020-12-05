package com.iii.amirutham.service;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.model.product.AmiruthamCategory;

public interface CategoryService {

	AmiruthamCategory createCategory(CategoryDto categories);

	public void createCategory(String products, List<MultipartFile> files);

	public List<CategoryDto> findAllCatogry();

	public List<AmiruthamCategory> findAllCatogrydao();

	public CategoryDto findCatogryById(int id);

	public void deleteCatogry(int id);

	AmiruthamCategory updateCategory( CategoryDto categories);

}
