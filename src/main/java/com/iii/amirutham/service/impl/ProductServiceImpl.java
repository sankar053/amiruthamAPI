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

import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.dto.model.ProductMediaDto;
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

	private String Upload_Path = "C:\\catalogs\\";

	@Override
	public void addImgToProduct(String productstr, List<MultipartFile> files) {

		 ProductDto products = (ProductDto) AmirthumUtills.convertJsontoObject(ProductDto.class, productstr);
	 	Optional<AmiruthamCategory> catogory = categryRepo.findById(Integer.valueOf(products.getCategoryid()));
	 	
	 	if(catogory.isPresent()) {
	 		AmiruthamProducts product = new AmiruthamProducts();
	 		product.setCategory(catogory.get());
	 		product.setProductCode(products.getProductCode());
	 		product.setProductNm(products.getProductNm());
	 		product.setProductDesc(products.getProductDesc());
	 		
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
			product.setProdImgs(mediaArray);
			productRepo.save(product);
	 	}
	 	
	 	
			
		
	}

	@Override
	public List<ProductDto> retriveProducts() {
		// TODO Auto-generated method stub

		List<AmiruthamProducts> prodList = productRepo.findAll();
		List<ProductDto> productlistdto = new ArrayList<ProductDto>();

		for (AmiruthamProducts prod : prodList) {
			List<ProductMediaDto> mediaarray = new ArrayList<ProductMediaDto>();
			if (null != prod.getProdImgs() && prod.getProdImgs().size() > 0) {
				for (ProductMediaGallary prodmed : prod.getProdImgs()) {
					mediaarray.add(new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
							prodmed.getProdImgPath(), prodmed.getProdImgurl()));
				}
				// }

			}
			
			  productlistdto.add(new ProductDto(prod.getId(),String.valueOf(prod.getCategory().getId()), prod.getProductCode(),
			  prod.getProductNm(), prod.getProductDesc(), prod.getProductuses(),
			  mediaarray));
			 
		}

		return productlistdto;
	}

	@Override
	public ProductDto retriveProductById(int id) {
		// TODO Auto-generated method stub
		Optional<AmiruthamProducts> product = productRepo.findById(id);
		ProductDto productdto = null;
		if (product.isPresent()) {
			AmiruthamProducts prod = product.get();
			List<ProductMediaDto> mediaarray = new ArrayList<ProductMediaDto>();
			if (null != prod.getProdImgs() && prod.getProdImgs().size() > 0) {
				for (ProductMediaGallary prodmed : prod.getProdImgs()) {
					mediaarray.add(new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
							prodmed.getProdImgPath(), prodmed.getProdImgurl()));
				}
				// }

			}
			/*
			 * productdto = (new ProductDto(prod.getId(), prod.getProductCode(),
			 * prod.getProductNm(), prod.getProductDesc(), prod.getProductuses(),
			 * mediaarray));
			 */
		}

		return productdto;

	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}

}
