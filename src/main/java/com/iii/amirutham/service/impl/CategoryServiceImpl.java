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
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.modelmapper.ModelMapper;
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
import com.iii.amirutham.exception.FileStorageException;
import com.iii.amirutham.exception.MyFileNotFoundException;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.product.AmiruthamCategory;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.product.CategoryBanner;
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

	@Autowired
	private ModelMapper modelMapper;

	@Override
	public void createBulkCategory(CategoryRequest categoryRequest, List<MultipartFile> files) {
		// TODO Auto-generated method stub

		for (CategoryDto categoryDto : categoryRequest.getCategories()) {
			AmiruthamCategory category = new AmiruthamCategory();
			SequnceDto sequence = seqservice.findMySeQuence("CATEGERY");
			category.setCategoryCd(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			category.setCategoryDesc(categoryDto.getCategoryDesc());
			category.setCategoryNm(categoryDto.getCategoryNm());
			category.setCategoryOrder(categoryDto.getCategoryOrder());

			if (null != files) {
				List<CategoryBanner> mediaArray = new ArrayList<CategoryBanner>();
				fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator + "category" + File.separator
						+ category.getCategoryCd() + File.separator).toAbsolutePath().normalize();
				AmirthumUtills.makeaDirectory(fileStorageLocation);
				int filecount = 0;
				for (MultipartFile file : files) {

					try {
						String fileName = StringUtils.cleanPath(file.getOriginalFilename());
						if (fileName.contains("..")) {
							throw new FileStorageException(
									"Sorry! Filename contains invalid path sequence " + fileName);
						}
						String productfilename = category.getCategoryCd() + "_" + filecount++
								+ fileName.substring(fileName.lastIndexOf("."));
						Path targetLocation = fileStorageLocation.resolve(productfilename);
						Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

						String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
								.path("/category/downloadFile/").path(productfilename + "/" + category.getCategoryCd())
								.toUriString();

						mediaArray.add(new CategoryBanner(productfilename, targetLocation.toString(), fileDownloadUri,
								file.getContentType(), file.getSize(), category));
					} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
						e.printStackTrace();
					}

				}
				category.setBannerImgs(mediaArray);
				categryRepo.save(category);
			}

		}

	}

	@Override
	public List<CategoryDto> findAllCatogry() {
		List<AmiruthamCategory> catogDaoList = categryRepo.findAll();
		List<CategoryDto> catoglistdto = new ArrayList<CategoryDto>();
		for (AmiruthamCategory category : catogDaoList) {

			CategoryDto catgryDto = ((CategoryDto) AmirthumUtills.convertToDto(category, CategoryDto.class,
					modelMapper));
			catoglistdto.add(catgryDto);

		}

		return catoglistdto;

	}

	@Override
	public CategoryDto findCatogryById(int id) {

		Optional<AmiruthamCategory> categoryDao = categryRepo.findById(id);

		if (categoryDao.isPresent()) {
			CategoryDto catgryDto = ((CategoryDto) AmirthumUtills.convertToDto(categoryDao.get(), CategoryDto.class,
					modelMapper));
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
	public AmiruthamCategory createCategory(CategoryDto categoryDto, List<MultipartFile> files) {

		AmiruthamCategory category = new AmiruthamCategory();
		SequnceDto sequence = seqservice.findMySeQuence("CATEGERY");
		category.setCategoryCd(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
		seqservice.updateMySeQuence(sequence);
		category.setCategoryDesc(categoryDto.getCategoryDesc());
		category.setCategoryNm(categoryDto.getCategoryNm());
		category.setCategoryOrder(categoryDto.getCategoryOrder());
		category.setIsActive("true".equals(categoryDto.getCategoryActiveYN())?"Y":"N");
		if (null != files) {
			List<CategoryBanner> mediaArray = new ArrayList<CategoryBanner>();
			fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator + "category" + File.separator
					+ category.getCategoryCd() + File.separator).toAbsolutePath().normalize();
			AmirthumUtills.makeaDirectory(fileStorageLocation);
			int filecount = 0;
			for (MultipartFile file : files) {

				try {
					String fileName = StringUtils.cleanPath(file.getOriginalFilename());
					if (fileName.contains("..")) {
						throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
					}
					String productfilename = category.getCategoryCd() + "_" + filecount++
							+ fileName.substring(fileName.lastIndexOf("."));
					Path targetLocation = fileStorageLocation.resolve(productfilename);
					Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

					String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
							.path("/category/downloadFile/").path(productfilename + "/" + category.getCategoryCd())
							.toUriString();

					mediaArray.add(new CategoryBanner(productfilename, targetLocation.toString(), fileDownloadUri,
							file.getContentType(), file.getSize(), category));
				} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
					e.printStackTrace();
				}

			}
			category.setBannerImgs(mediaArray);
			return categryRepo.save(category);
		}
		return category;

	}

	@Override
	public void deleteCatogry(int id) {
		// TODO Auto-generated method stub
		categryRepo.deleteById(id);
		;
	}

	@Override
	public AmiruthamCategory updateCategory(CategoryDto categoryDto, List<MultipartFile> files) {
		// TODO Auto-generated method stub

		Optional<AmiruthamCategory> catogory = categryRepo.findById(categoryDto.getId());
		if (catogory.isPresent()) {
			AmiruthamCategory categoryDao = catogory.get();
			categoryDao.setCategoryDesc(categoryDto.getCategoryDesc());
			categoryDao.setCategoryNm(categoryDto.getCategoryNm());
			categoryDao.setCategoryOrder(categoryDto.getCategoryOrder());
			categoryDao.setIsActive("true".equals(categoryDto.getCategoryActiveYN())?"Y":"N");
			if (null != files) {
			
				fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator + "category" + File.separator
						+ categoryDao.getCategoryCd() + File.separator).toAbsolutePath().normalize();
				AmirthumUtills.makeaDirectory(fileStorageLocation);
				int filecount = 0;
				for (MultipartFile file : files) {

					try {
						String fileName = StringUtils.cleanPath(file.getOriginalFilename());
						if (fileName.contains("..")) {
							throw new FileStorageException(
									"Sorry! Filename contains invalid path sequence " + fileName);
						}
						String productfilename = categoryDao.getCategoryCd() + "_" + filecount++
								+ fileName.substring(fileName.lastIndexOf("."));
						Path targetLocation = fileStorageLocation.resolve(productfilename);
						Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

						String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
								.path("/category/downloadFile/")
								.path(productfilename + "/" + categoryDao.getCategoryCd()).toUriString();

						categoryDao.getBannerImgs().add(new CategoryBanner(productfilename, targetLocation.toString(), fileDownloadUri,
								file.getContentType(), file.getSize(), categoryDao));
					} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
						e.printStackTrace();
					}

				}
						
			}
			return categryRepo.save(categoryDao);

		} else {
			throw new UserNotFoundException("Category Not Found  " + categoryDto.getId());
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
			fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator +"category"+File.separator+ catCode + File.separator)
					.toAbsolutePath().normalize();
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
