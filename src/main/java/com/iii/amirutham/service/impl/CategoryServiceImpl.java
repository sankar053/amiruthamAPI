package com.iii.amirutham.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.dto.model.ProductMediaDto;
import com.iii.amirutham.model.UserAddress;
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
	
	@Autowired
	private ProductRepository productRepo;


	@Override
	public void createCategory(CategoryDto categories) {
		// TODO Auto-generated method stub

		AmiruthamCategory catogory = new AmiruthamCategory(categories.getCategoryCd(), categories.getCategoryNm(),
				categories.getCategoryDesc());

		categryRepo.save(catogory);

	}

	@Override
	public List<CategoryDto> findAllCatogry() {
		List<AmiruthamCategory> catogList = categryRepo.findAll();
		List<CategoryDto> catoglistdto = new ArrayList<CategoryDto>();
		for (AmiruthamCategory cato : catogList) {
			CategoryDto catgryDto = new CategoryDto();
			catgryDto.setCategoryCd(cato.getCategoryCd());
			catgryDto.setCategoryDesc(cato.getCategoryDesc());
			catgryDto.setCategoryNm(cato.getCategoryNm());
			
			/*
			 * Set<AmiruthamProducts> products = cato.getProducts(); if (products != null &&
			 * products.size() > 0) {
			 */
				for (AmiruthamProducts prod : cato.getProducts()) {
					List<ProductMediaDto> mediaarray = new ArrayList<ProductMediaDto>();
					if (null!=prod.getProdImgs() && prod.getProdImgs().size() > 0) {
						for (ProductMediaGallary prodmed : prod.getProdImgs()) {
							mediaarray.add(new ProductMediaDto(0, prodmed.getProdImgNm(), prodmed.getProdImgPath(),
									prodmed.getProdImgurl()));
						}
					//}
					new ProductDto(prod.getId(), cato.getId(), prod.getProductCode(), prod.getProductNm(),
							prod.getProductDesc(), mediaarray);
				}
			}
				catoglistdto.add(catgryDto);
			/*
			 * catgryDto.setProducts(cato.getProducts().stream().map(prod -> new
			 * ProductDto(prod.getId(), cato.getId(), prod.getProductCode(),
			 * prod.getProductNm(), prod.getProductDesc(), prod.getProdImgs().stream()
			 * .map(prodmed -> new ProductMediaDto(0, prodmed.getProdImgNm(),
			 * prodmed.getProdImgPath(), prodmed.getProdImgurl()))
			 * .collect(Collectors.toList()))) .collect(Collectors.toList()));
			 */

		}

		return catoglistdto;

	}

	@Override
	public Optional<AmiruthamCategory> findCatogryById(int id) {

		return categryRepo.findById(id);

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
		AmiruthamProducts product = null;
		for (ProductDto products : categoryDto.getProducts()) {
			product = new AmiruthamProducts(products.getProductCode(), products.getProductNm(),
					products.getProductDesc());
			category.getProducts().add(product);

		}

		/*
		 * List<ProductMediaGallary> mediaArray = new ArrayList<ProductMediaGallary>();
		 * if (null != files) { for (MultipartFile file : files) {
		 * 
		 * try {
		 * 
		 * byte[] bytes = file.getBytes(); Path path = Paths.get("C:\\catalogs\\" +
		 * file.getOriginalFilename()); Files.write(path, bytes);
		 * 
		 * mediaArray.add(new ProductMediaGallary(file.getOriginalFilename(),
		 * "C:\\catalogs\\" + file.getOriginalFilename(), "http://Localhost:8080/files")
		 * ); } catch (IOException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * } // TODO Auto-generated method stub } } product.setProdImgs(mediaArray);
		 */
		categryRepo.save(category);
		
	}

}
