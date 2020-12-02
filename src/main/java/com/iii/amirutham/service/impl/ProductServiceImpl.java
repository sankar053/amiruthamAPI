package com.iii.amirutham.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.repo.CategoryRepository;
import com.iii.amirutham.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private CategoryRepository categryRepo;

	@Override
	public void createProduct(CategoryDto categories) {
		// TODO Auto-generated method stub

		AmiruthamCategory catogory = new AmiruthamCategory(categories.getCategoryCd(), categories.getCategoryNm(),
				categories.getCategoryDesc());

		Set<ProductDto> poductList = categories.getProducts();

		if (null != poductList) {
			for (ProductDto prod : poductList) {
				AmiruthamProducts productDao = new AmiruthamProducts(prod.getProductCode(), prod.getProductNm(),
						prod.getProductDesc());
				catogory.getProducts().add(productDao);
				//productDao.getCategory().add(catogory);
				
			}
		}
		categryRepo.save(catogory);
		

	}

	@Override
	public List<CategoryDto> findAllCatogry() {
		List<AmiruthamCategory> catogList = categryRepo.findAll();
		List<CategoryDto> catoglist  = new ArrayList<CategoryDto>();
		for(AmiruthamCategory cato : catogList) {
			CategoryDto catgryDto = new CategoryDto();
			catgryDto.setCategoryCd(cato.getCategoryCd());
			catgryDto.setCategoryDesc(cato.getCategoryDesc());
			catgryDto.setCategoryNm(cato.getCategoryNm());
			catoglist.add(catgryDto);
		}
		
		return catoglist;
		
	}

	@Override
	public Optional<AmiruthamCategory> findCatogryById(int id) {
		
		return categryRepo.findById(id);
		
	}

}
