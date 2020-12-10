package com.iii.amirutham.service.impl;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.dto.model.ProductMediaDto;
import com.iii.amirutham.dto.model.ProductVarientDto;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.exception.FileStorageException;
import com.iii.amirutham.exception.MyFileNotFoundException;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.ProductMediaGallary;
import com.iii.amirutham.repo.CategoryRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.service.ProductService;
import com.iii.amirutham.service.SequenceService;
import com.iii.amirutham.utills.AmirthumUtills;

@Service
public class ProductServiceImpl implements ProductService {

	@Autowired
	private ProductRepository productRepo;
	private String Upload_Path = "C:\\Amirthum\\";

	//private Path fileStorageLocation = Paths.get(Upload_Path).toAbsolutePath().normalize();

	@Autowired
	private CategoryRepository categryRepo;
	
	@Autowired
	private SequenceService seqservice;

	@Override
	public AmiruthamProducts addProductandMedia(String productstr, List<MultipartFile> files) {

		ProductDto productsDto = (ProductDto) AmirthumUtills.convertJsontoObject(ProductDto.class, productstr);
		Optional<AmiruthamCategory> catogory = categryRepo.findById(Integer.valueOf(productsDto.getCategoryid()));
		Path fileStorageLocation = Paths.get(Upload_Path+catogory.get().getCategoryCd()+"//").toAbsolutePath().normalize();
		if (catogory.isPresent()) {
			AmiruthamProducts product = new AmiruthamProducts();
			product.setCategory(catogory.get());
			SequnceDto sequence =seqservice.findMySeQuence("PRODUCT");
			product.setProductCode(sequence.getSeqChar()+String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			product.setProductNm(productsDto.getProductNm());
			product.setProductDesc(productsDto.getProductDesc());

			List<ProductMediaGallary> mediaArray = new ArrayList<ProductMediaGallary>();
			if (null != files) {
				for (MultipartFile file : files) {

					try {
						String fileName = StringUtils.cleanPath(file.getOriginalFilename());
						if (fileName.contains("..")) {
							throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
						}
						Path targetLocation = fileStorageLocation.resolve(fileName);
						Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
						
						String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
				                .path("/products/downloadFile/")
				                .path(fileName)
				                .toUriString();

						mediaArray.add(new ProductMediaGallary(fileName, targetLocation.toString(),
								fileDownloadUri,file.getContentType(),file.getSize()));
					} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }

					}
					// TODO Auto-generated method stub
				}
			}
			product.setProdImgs(mediaArray);
			return productRepo.save(product);
		}else {
			throw new UserNotFoundException("Category Not Found  " + productsDto.getCategoryid());
		}

	}

	@Override
	public List<ProductDto> retriveProducts() {
		// TODO Auto-generated method stub

		List<AmiruthamProducts> prodList = productRepo.findAll();
		List<ProductDto> productlistdto = new ArrayList<ProductDto>();

		for (AmiruthamProducts prod : prodList) {
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
			productlistdto
					.add(new ProductDto(prod.getId(), String.valueOf(prod.getCategory().getId()), prod.getProductCode(),
							prod.getProductNm(), prod.getProductDesc(), prod.getProductuses(), mediaarray,productVarient));

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
			productdto =new ProductDto(prod.getId(), String.valueOf(prod.getCategory().getId()), prod.getProductCode(),
							prod.getProductNm(), prod.getProductDesc(), prod.getProductuses(), mediaarray,productVarient);

			}
	
		return productdto;

	}

	@Override
	public void deleteProductById(int id) {
		// TODO Auto-generated method stub
		productRepo.deleteById(id);
	}
	
	 public Resource loadProductAsResource(String fileName,String catCode) {
	        try {
	        	Path fileStorageLocation = Paths.get(Upload_Path+catCode+"//").toAbsolutePath().normalize();
	            Path filePath = fileStorageLocation.resolve(fileName).normalize();
	            Resource resource = new UrlResource(filePath.toUri());
	            if(resource.exists()) {
	                return resource;
	            } else {
	                throw new MyFileNotFoundException("File not found " + fileName);
	            }
	        } catch (MalformedURLException ex) {
	            throw new MyFileNotFoundException("File not found " + fileName, ex);
	        }
	    }

}
