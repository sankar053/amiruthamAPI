package com.iii.amirutham.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductMediaGallary;
import com.iii.amirutham.repo.CategoryRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.service.ProductService;
import com.iii.amirutham.utills.AmirthumUtills;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private CategoryRepository categryRepo;

	@Override
	public void createProduct(ProductDto products, MultipartFile files[]) {
		// TODO Auto-generated method stub

		Optional<AmiruthamCategory> category = categryRepo.findById(products.getCategId());

		if (category.isPresent()) {
			AmiruthamProducts product = new AmiruthamProducts(products.getProductCode(), products.getProductNm(),
					products.getProductDesc());
			product.getCategory().add(category.get());
			productRepo.save(product);
		}

		/*
		 * List<ProductMediaGallary> mediaArray= new ArrayList<ProductMediaGallary>();
		 * if (null != files) { for (MultipartFile file : files) { byte[] bytes; try {
		 * bytes = file.getBytes(); Path path = Paths.get("C:\\catalogs" +
		 * file.getOriginalFilename()); Files.write(path, bytes);
		 * 
		 * mediaArray.add(new
		 * ProductMediaGallary(file.getOriginalFilename(),"C:\\catalogs" +
		 * file.getOriginalFilename(), "http://Localhost:8080/files")); } catch
		 * (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
		 * 
		 * 
		 * } }
		 */

	}
	
	//@Override
	public void createProduct1(String productstr, List<MultipartFile> files) {

		ProductDto products = (ProductDto) AmirthumUtills.convertJsontoObject(ProductDto.class, productstr);
		

	
			

		

		List<ProductMediaGallary> mediaArray = new ArrayList<ProductMediaGallary>();
		if (null != files) {
			for (MultipartFile file : files) {

				try {

					byte[] bytes = file.getBytes();
					Path path = Paths.get("C:\\catalogs\\" + file.getOriginalFilename());
					Files.write(path, bytes);

					mediaArray.add(new ProductMediaGallary(file.getOriginalFilename(),
							"C:\\catalogs\\" + file.getOriginalFilename(), "http://Localhost:8080/files"));
				} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }

				}
				// TODO Auto-generated method stub
			}
		}
		AmiruthamProducts	product = new AmiruthamProducts(products.getId(),products.getProductCode(), products.getProductNm(),
				products.getProductDesc(),mediaArray);
		product.setProdImgs(mediaArray);
		productRepo.save(product);
	}

	@Override
	public void createProduct(String productstr, List<MultipartFile> files) {

		//ProductDto products = (ProductDto) AmirthumUtills.convertJsontoObject(ProductDto.class, productstr);
		Optional<AmiruthamProducts> product = productRepo.findById(Integer.valueOf(productstr));
	
if(product.isPresent()) {
	AmiruthamProducts prod=product.get();
		List<ProductMediaGallary> mediaArray = new ArrayList<ProductMediaGallary>();
		if (null != files) {
			for (MultipartFile file : files) {

				try {

					byte[] bytes = file.getBytes();
					Path path = Paths.get("C:\\catalogs\\" + file.getOriginalFilename());
					Files.write(path, bytes);

					mediaArray.add(new ProductMediaGallary(file.getOriginalFilename(),
							"C:\\catalogs\\" + file.getOriginalFilename(), "http://Localhost:8080/files"));
				} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }

				}
				// TODO Auto-generated method stub
			}
		}
		prod.setProdImgs(mediaArray);
		productRepo.save(prod);
		
		//System.out.println(categryRepo.findById(14).isPresent());
		
}
	}

}
