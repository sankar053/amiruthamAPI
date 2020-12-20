package com.iii.amirutham.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.base.CategoryRequest;
import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.dto.model.ProductMediaDto;
import com.iii.amirutham.dto.model.ProductVarientDto;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.exception.AmirthumCommonException;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.repo.CategoryRepository;
import com.iii.amirutham.service.CategoryService;
import com.iii.amirutham.service.SequenceService;
import com.iii.amirutham.utills.AmirthumUtills;

@Service
public class CategoryServiceImpl implements CategoryService {

	@Autowired
	private CategoryRepository categryRepo;

	@Autowired
	private SequenceService seqservice;

	/*
	 * @Autowired private ProductRepository productRepo;
	 */
	@Override
	public void createCategory(CategoryRequest categoryRequest) {
		// TODO Auto-generated method stub
		List<AmiruthamCategory> categoryList = new ArrayList<>();
		for (CategoryDto categoryDto : categoryRequest.getCategories()) {
			AmiruthamCategory category = new AmiruthamCategory();
			SequnceDto sequence = seqservice.findMySeQuence("CATEGERY");
			category.setCategoryCd(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			category.setCategoryDesc(categoryDto.getCategoryDesc());
			category.setCategoryNm(categoryDto.getCategoryNm());
			categoryList.add(category);
		}
		categryRepo.saveAll(categoryList);
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
				List<ProductMediaDto> mediaarray = null;
				List<ProductVarientDto> productVarient = null;
				if (null != prod.getProdImgs() && prod.getProdImgs().size() > 0) {
					mediaarray = prod.getProdImgs().stream()
							.map(prodmed -> new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
									prodmed.getProdImgPath(), prodmed.getProdImgUrl(), prodmed.getProdImgType(),
									prodmed.getProdImgSize()))
							.collect(Collectors.toList());

				}
				if (null != prod.getProdVarient() && prod.getProdVarient().size() > 0) {
					productVarient = prod.getProdVarient().stream()
							.map(varient -> new ProductVarientDto(varient.getId(), varient.getMaximumRetailPrice(),
									varient.getSellingPrice(), varient.getSavedPrice(), varient.getDiscount(),
									varient.getUnit(), varient.getUnitType(), varient.getManufactureDate(),
									varient.getBestBeforeDate(), prod.getId()))
							.collect(Collectors.toList());
				}

				catgryDto.getProducts().add(new ProductDto(prod.getId(), "", prod.getProductCode(), prod.getProductNm(),
						prod.getProductDesc(), prod.getProductuses(),prod.getProductincredience(),prod.getStock(), mediaarray, productVarient));
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
				List<ProductMediaDto> mediaarray = null;
				List<ProductVarientDto> productVarient = null;
				if (null != prod.getProdImgs() && prod.getProdImgs().size() > 0) {
					mediaarray = prod.getProdImgs().stream()
							.map(prodmed -> new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
									prodmed.getProdImgPath(), prodmed.getProdImgUrl(), prodmed.getProdImgType(),
									prodmed.getProdImgSize()))
							.collect(Collectors.toList());

				}
				if (null != prod.getProdVarient() && prod.getProdVarient().size() > 0) {
					productVarient = prod.getProdVarient().stream()
							.map(varient -> new ProductVarientDto(varient.getId(), varient.getMaximumRetailPrice(),
									varient.getSellingPrice(), varient.getSavedPrice(), varient.getDiscount(),
									varient.getUnit(), varient.getUnitType(), varient.getManufactureDate(),
									varient.getBestBeforeDate(), prod.getId()))
							.collect(Collectors.toList());
				}

				catgryDto.getProducts().add(new ProductDto(prod.getId(), "", prod.getProductCode(), prod.getProductNm(),
						prod.getProductDesc(), prod.getProductuses(),prod.getProductincredience(),prod.getStock(), mediaarray, productVarient));
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
