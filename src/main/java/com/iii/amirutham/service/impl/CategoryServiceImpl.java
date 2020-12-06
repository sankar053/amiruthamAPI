package com.iii.amirutham.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.dto.model.ProductMediaDto;
import com.iii.amirutham.exception.AmirthumCommonException;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductMediaGallary;
import com.iii.amirutham.repo.CategoryRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.service.CategoryService;
import com.iii.amirutham.utills.AmirthumUtills;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categryRepo;

	/*
	 * @Autowired private ProductRepository productRepo;
	 */
	@Override
	public AmiruthamCategory createCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub
		if (null == categoryDto.getId()) {
			AmiruthamCategory category = new AmiruthamCategory();
			category.setCategoryCd(categoryDto.getCategoryCd());
			category.setCategoryDesc(categoryDto.getCategoryDesc());
			category.setCategoryNm(categoryDto.getCategoryNm());
			return categryRepo.save(category);
		}
		return null;
	}

	@Override
	public List<CategoryDto> findAllCatogry() {
		List<AmiruthamCategory> catogList = categryRepo.findAll();
		List<CategoryDto> catoglistdto = new ArrayList<CategoryDto>();
		for (AmiruthamCategory cato : catogList) {
			CategoryDto catgryDto = new CategoryDto();
			catgryDto.setId(cato.getId());
			catgryDto.setCategoryCd(cato.getCategoryCd());
			catgryDto.setCategoryDesc(cato.getCategoryDesc());
			catgryDto.setCategoryNm(cato.getCategoryNm());

			for (AmiruthamProducts prod : cato.getProducts()) {
				List<ProductMediaDto> mediaarray = new ArrayList<ProductMediaDto>();
				if (null != prod.getProdImgs() && prod.getProdImgs().size() > 0) {
					for (ProductMediaGallary prodmed : prod.getProdImgs()) {
						mediaarray.add(new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
								prodmed.getProdImgPath(), prodmed.getProdImgUrl(),prodmed.getProdImgType(),prodmed.getProdImgSize()));
					}
					
				}
				catgryDto.getProducts().add(new ProductDto(prod.getId(), "", prod.getProductCode(), prod.getProductNm(),
						prod.getProductDesc(), prod.getProductuses(), mediaarray));
			}
			catoglistdto.add(catgryDto);

		}

		return catoglistdto;

	}

	@Override
	public CategoryDto findCatogryById(int id) {

		Optional<AmiruthamCategory> categoryDao = categryRepo.findById(id);

		if (categoryDao.isPresent()) {
			AmiruthamCategory cato = categoryDao.get();
			CategoryDto catgryDto = new CategoryDto();
			catgryDto.setId(cato.getId());
			catgryDto.setCategoryCd(cato.getCategoryCd());
			catgryDto.setCategoryDesc(cato.getCategoryDesc());
			catgryDto.setCategoryNm(cato.getCategoryNm());

			/*
			 * Set<AmiruthamProducts> products = cato.getProducts(); if (products != null &&
			 * products.size() > 0) {
			 */
			for (AmiruthamProducts prod : cato.getProducts()) {
				List<ProductMediaDto> mediaarray = new ArrayList<ProductMediaDto>();
				if (null != prod.getProdImgs() && prod.getProdImgs().size() > 0) {
					for (ProductMediaGallary prodmed : prod.getProdImgs()) {
						mediaarray.add(new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
								prodmed.getProdImgPath(), prodmed.getProdImgUrl(),prodmed.getProdImgType(),prodmed.getProdImgSize()));
					}
					// }

				}
				catgryDto.getProducts().add(new ProductDto(prod.getId(), "", prod.getProductCode(), prod.getProductNm(),
						prod.getProductDesc(), prod.getProductuses(), mediaarray));
			}
			return catgryDto;
		}
		return null;

	}

	@Override
	public List<AmiruthamCategory> findAllCatogrydao() {
		// TODO Auto-generated method stub
		List<AmiruthamCategory> catogList = categryRepo.findAll();
		return catogList;
	}

	@Override
	public void createCategory(String catogryStr, List<MultipartFile> files) {

		CategoryDto categoryDto = (CategoryDto) AmirthumUtills.convertJsontoObject(CategoryDto.class, catogryStr);

		AmiruthamCategory category = new AmiruthamCategory();
		category.setCategoryCd(categoryDto.getCategoryCd());
		category.setCategoryDesc(categoryDto.getCategoryDesc());
		category.setCategoryNm(categoryDto.getCategoryNm());

		categryRepo.save(category);

	}

	@Override
	public void deleteCatogry(int id) {
		// TODO Auto-generated method stub
		categryRepo.deleteById(id);
		;
	}

	@Override
	public AmiruthamCategory updateCategory(CategoryDto categoryDto) {
		// TODO Auto-generated method stub

		if (null != categoryDto.getId()) {
			Optional<AmiruthamCategory> catogory = categryRepo.findById(categoryDto.getId());
			if (catogory.isPresent()) {
				AmiruthamCategory categoryDao = catogory.get();
				categoryDao.setCategoryCd(categoryDto.getCategoryCd());
				categoryDao.setCategoryDesc(categoryDto.getCategoryDesc());
				categoryDao.setCategoryNm(categoryDto.getCategoryNm());
				return categryRepo.save(categoryDao);
			} else {
				throw new UserNotFoundException("Category Not Found  " + categoryDto.getId());
			}

		} else {
			throw new AmirthumCommonException("Category id shoud Not be Empty");
		}

	}

}
