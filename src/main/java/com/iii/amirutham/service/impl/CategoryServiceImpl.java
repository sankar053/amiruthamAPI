package com.iii.amirutham.service.impl;

import java.io.File;
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

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iii.amirutham.dto.base.CategoryRequest;
import com.iii.amirutham.dto.model.CategoryDto;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.dto.model.ProductMediaDto;
import com.iii.amirutham.dto.model.ProductVarientDto;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.exception.AmirthumCommonException;
import com.iii.amirutham.exception.FileStorageException;
import com.iii.amirutham.exception.MyFileNotFoundException;
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
	
	@Value("${amirthum.file.upload-dir}")
	private String Upload_Path;

	private Path fileStorageLocation;

	@Override
	public void createBulkCategory(CategoryRequest categoryRequest,MultipartFile files) {
		// TODO Auto-generated method stub
		List<AmiruthamCategory> categoryList = new ArrayList<>();
		for (CategoryDto categoryDto : categoryRequest.getCategories()) {
			AmiruthamCategory category = new AmiruthamCategory();
			SequnceDto sequence = seqservice.findMySeQuence("CATEGERY");
			category.setCategoryCd(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			category.setCategoryDesc(categoryDto.getCategoryDesc());
			category.setCategoryNm(categoryDto.getCategoryNm());
			category.setCategoryOrder(categoryDto.getCategoryOrder());
		
			if (null != files) {

				try {
					
					fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator+category.getCategoryCd()+File.separator).toAbsolutePath().normalize();
					AmirthumUtills.makeaDirectory(fileStorageLocation);
					String fileName = StringUtils.cleanPath(files.getOriginalFilename());
					if (fileName.contains("..")) {
						throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
					}
					Path targetLocation = fileStorageLocation.resolve(fileName);

					Files.copy(files.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
					category.setBannerFileNm(fileName);
					category.setBannerFilepth(targetLocation.toString());
					category.setBannerImgSize(files.getSize());
					category.setBannerImgType(files.getContentType());
					String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
							.path("/category/downloadFile/").path(fileName).toUriString();

					category.setBannerImgUrl(fileDownloadUri);
				
				} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
					e.printStackTrace();
				}
		}
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
			catgryDto.setCategoryOrder(cato.getCategoryOrder());
			catgryDto.setCategoryBannerImgURL(cato.getBannerImgUrl());
			catgryDto.setCreatedTs(cato.getCreatedTs());
			catgryDto.setUpdatedTs(cato.getUpdatedTs());
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
									varient.getBestBeforeDate(), prod.getId(), varient.getStock()))
							.collect(Collectors.toList());
				}

				catgryDto.getProducts()
						.add(new ProductDto(prod.getId(), 0, prod.getProductCode(), prod.getProductNm(),
								prod.getProductDesc(), prod.getProductuses(), prod.getProductincredience(), mediaarray,
								productVarient,prod.getProductBestSellingYN()));
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
			catgryDto.setCategoryOrder(cato.getCategoryOrder());
			catgryDto.setCreatedTs(cato.getCreatedTs());
			catgryDto.setCategoryBannerImgURL(cato.getBannerImgUrl());
			catgryDto.setUpdatedTs(cato.getUpdatedTs());
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
									varient.getBestBeforeDate(), prod.getId(), varient.getStock()))
							.collect(Collectors.toList());
				}

				catgryDto.getProducts()
						.add(new ProductDto(prod.getId(), 0, prod.getProductCode(), prod.getProductNm(),
								prod.getProductDesc(), prod.getProductuses(), prod.getProductincredience(), mediaarray,
								productVarient,prod.getProductBestSellingYN()));
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
	public AmiruthamCategory createCategory(String catogryStr, MultipartFile files) {

		CategoryDto categoryDto = (CategoryDto) AmirthumUtills.convertJsontoObject(CategoryDto.class, catogryStr);

		AmiruthamCategory category = new AmiruthamCategory();
		SequnceDto sequence = seqservice.findMySeQuence("CATEGERY");
		category.setCategoryCd(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
		seqservice.updateMySeQuence(sequence);
		category.setCategoryDesc(categoryDto.getCategoryDesc());
		category.setCategoryNm(categoryDto.getCategoryNm());
		category.setCategoryOrder(categoryDto.getCategoryOrder());
		
		if (null != files) {

			try {
				
				fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator+category.getCategoryCd()+File.separator).toAbsolutePath().normalize();
				AmirthumUtills.makeaDirectory(fileStorageLocation);
				String fileName = StringUtils.cleanPath(files.getOriginalFilename());
				if (fileName.contains("..")) {
					throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
				}
				Path targetLocation = fileStorageLocation.resolve(fileName);

				Files.copy(files.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
				category.setBannerFileNm(fileName);
				category.setBannerFilepth(targetLocation.toString());
				category.setBannerImgSize(files.getSize());
				category.setBannerImgType(files.getContentType());
				String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
						.path("/category/downloadFile/").path(fileName+"/"+category.getCategoryCd()).toUriString();

				category.setBannerImgUrl(fileDownloadUri);
			
			} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
				e.printStackTrace();
			}
	}
		return categryRepo.save(category);

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
				//categoryDao.setCategoryBannerImgURL(categoryDto.getCategoryBannerImgURL());
				return categryRepo.save(categoryDao);
			} else {
				throw new UserNotFoundException("Category Not Found  " + categoryDto.getId());
			}

		} else {
			throw new AmirthumCommonException("Category id shoud Not be Empty");
		}

	}

	@Override
	public void createBulkCategory(@Valid @NotNull @NotBlank MultipartFile files) {
		// TODO Auto-generated method stub

		// Creating a Workbook from an Excel file (.xls or .xlsx)
		Workbook workbook;
		try {
			workbook = WorkbookFactory.create(files.getInputStream());
			System.out.println("Workbook has " + workbook.getNumberOfSheets() + " Sheets : ");
			System.out.println("Retrieving Sheets using Java 8 forEach with lambda");
			DataFormatter dataFormatter = new DataFormatter();
			workbook.forEach(sheet -> {
				System.out.println("=> " + sheet.getSheetName());
				if ("CAT".equals(sheet.getSheetName())) {
					List<AmiruthamCategory> categoryList = new ArrayList<>();
					sheet.forEach(row -> {
						AmiruthamCategory category = new AmiruthamCategory();
						if (0 != row.getRowNum()) {

							SequnceDto sequence = seqservice.findMySeQuence("CATEGERY");
							category.setCategoryCd(
									sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
							seqservice.updateMySeQuence(sequence);
							int cellcount = 0;
							for (Cell cell : row) {
								category = printCellValue(cell, cellcount, category);
								cellcount++;
							}
							categoryList.add(category);
						}
						
					});
					categryRepo.saveAll(categoryList);
				} else {
					System.out.println("=> " + sheet.getSheetName());
				}
			});

		} catch (EncryptedDocumentException | InvalidFormatException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

//		List<AmiruthamCategory> categoryList = new ArrayList<>();
//		if (null !=files) {
//			CategoryDto categoryDto =null;
//			AmiruthamCategory category = new AmiruthamCategory();
//			SequnceDto sequence = seqservice.findMySeQuence("CATEGERY");
//			category.setCategoryCd(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
//			seqservice.updateMySeQuence(sequence);
//			category.setCategoryDesc(categoryDto.getCategoryDesc());
//			category.setCategoryNm(categoryDto.getCategoryNm());
//			category.setCategoryOrder(categoryDto.getCategoryOrder());
//			category.setCategoryBannerImgURL(categoryDto.getCategoryBannerImgURL());
//			categoryList.add(category);
//		}
//		categryRepo.saveAll(categoryList);

	}

	private AmiruthamCategory printCellValue(Cell cell, int cellcount, AmiruthamCategory category) {
		switch (cell.getCellTypeEnum()) {
		case BOOLEAN:
			System.out.print(cell.getBooleanCellValue());
			break;
		case STRING:
			if (1 == cellcount)
				category.setCategoryNm(cell.getRichStringCellValue().getString());
			else if (2 == cellcount)
				category.setCategoryDesc(cell.getRichStringCellValue().getString());
			break;
		case NUMERIC:
			if (DateUtil.isCellDateFormatted(cell)) {
				System.out.print(cell.getDateCellValue());
			} else {
				System.out.print(cell.getNumericCellValue());
				if (3 == cellcount)
					category.setCategoryOrder((int) cell.getNumericCellValue());
			}
			break;
		case FORMULA:
			System.out.print(cell.getCellFormula());
			break;
		case BLANK:
			System.out.print("");
			break;
		default:
			System.out.print("");
		}

		System.out.print("\t");
		return category;
	}

	@Override
	public Resource loadBannerAsResource(String fileName, String catCode) {
		// TODO Auto-generated method stub
		try {
			fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator+catCode+File.separator).toAbsolutePath().normalize();
			Path filePath = fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}

}
