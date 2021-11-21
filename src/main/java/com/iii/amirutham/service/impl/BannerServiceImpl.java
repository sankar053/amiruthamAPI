/**
 * 
 */
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

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.model.BannerDto;
import com.iii.amirutham.dto.model.CustomerNewsLetterDto;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.dto.model.ProductMediaDto;
import com.iii.amirutham.dto.model.ProductVarientDto;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.exception.FileStorageException;
import com.iii.amirutham.exception.MyFileNotFoundException;
import com.iii.amirutham.model.CustomerNewsLetter;
import com.iii.amirutham.model.HomeBanner;
import com.iii.amirutham.model.HomeBannerMedia;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.repo.BannerRepository;
import com.iii.amirutham.repo.NewsLetterRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.service.BannerService;
import com.iii.amirutham.service.SequenceService;
import com.iii.amirutham.service.UserService;
import com.iii.amirutham.utills.AmirthumUtills;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sanka
 *
 */
@Slf4j
@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private UserService userService;

	@Autowired
	private BannerRepository bannerRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private ModelMapper modelMapper;

	@Autowired
	private SequenceService seqservice;

	@Autowired
	private NewsLetterRepository newsLetterRepository;

	@Value("${amirthum.file.upload-dir}")
	private String Upload_Path;

	private Path fileStorageLocation;

	@Override
	public void addHomeBanner(BannerDto bannerdto, List<MultipartFile> files) {

		UserDetailsImpl user = userService.getUserDetails();
		HomeBanner bannerDao = new HomeBanner();
		bannerDao.setBannerName(bannerdto.getBannerName());
		SequnceDto sequence = seqservice.findMySeQuence("BANNER");
		bannerDao.setBannerCode(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
		seqservice.updateMySeQuence(sequence);
		bannerDao.setBannerDesc(bannerdto.getBannerDesc());
		bannerDao.setInstaLink(bannerdto.getInstaLink());
		bannerDao.setFacebookLink(bannerdto.getFacebookLink());
		bannerDao.setYoutubeLink(bannerdto.getYoutubeLink());
		bannerDao.setWhatsappLink(bannerdto.getWhatsappLink());
		bannerDao.setCreatedBy(user.getFirstName());
		if (null != files) {
			List<HomeBannerMedia> mediaArray = new ArrayList<HomeBannerMedia>();
			fileStorageLocation = Paths
					.get(Upload_Path + "Banner" + File.separator + bannerDao.getBannerCode() + File.separator)
					.toAbsolutePath().normalize();
			AmirthumUtills.makeaDirectory(fileStorageLocation);
			int filecount = 0;
			for (MultipartFile file : files) {

				try {
					String fileName = StringUtils.cleanPath(file.getOriginalFilename());
					if (fileName.contains("..")) {
						throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
					}
					String productfilename = bannerDao.getBannerCode() + "_" + filecount++
							+ fileName.substring(fileName.lastIndexOf("."));
					Path targetLocation = fileStorageLocation.resolve(productfilename);
					Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

					
					String fileDownloadUri = "http://localhost:8085/api"+
					"/home/banner/downloadFile/"+productfilename + "/" + bannerDao.getBannerCode();
					
//					String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//							.path(":8085/home/banner/downloadFile/").path(productfilename + "/" + bannerDao.getBannerCode())
//							.toUriString();

					mediaArray.add(new HomeBannerMedia(productfilename, targetLocation.toString(), fileDownloadUri,
							file.getContentType(), file.getSize(), bannerDao));
				} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
					log.error("Banner service. {}",e.getMessage());
					e.printStackTrace();
				}
				// TODO Auto-generated method stub
			}
			bannerDao.setBannerImgs(mediaArray);
			bannerDao = bannerRepo.save(bannerDao);
		}

	}

	@Override
	public void updateHomeBanner(BannerDto bannerdto, List<MultipartFile> files) {
		// TODO Auto-generated method stub
		UserDetailsImpl user = userService.getUserDetails();
		Optional<HomeBanner> OptionalDao = bannerRepo.findById(bannerdto.getId());

		if (OptionalDao.isPresent()) {
			HomeBanner bannerDao = OptionalDao.get();
			bannerDao.setBannerName(bannerdto.getBannerName());
			bannerDao.setBannerCode(bannerdto.getBannerCode());
			bannerDao.setBannerDesc(bannerdto.getBannerDesc());
			bannerDao.setInstaLink(bannerdto.getInstaLink());
			bannerDao.setFacebookLink(bannerdto.getFacebookLink());
			bannerDao.setYoutubeLink(bannerdto.getYoutubeLink());
			bannerDao.setWhatsappLink(bannerdto.getWhatsappLink());
			bannerDao.setUpdatedBy(user.getFirstName());

			if (null != files) {
				fileStorageLocation = Paths
						.get(Upload_Path + "Banner" + File.separator + bannerDao.getBannerCode() + File.separator)
						.toAbsolutePath().normalize();
				AmirthumUtills.makeaDirectory(fileStorageLocation);
				for (MultipartFile file : files) {

					try {
						String fileName = StringUtils.cleanPath(file.getOriginalFilename());
						if (fileName.contains("..")) {
							throw new FileStorageException(
									"Sorry! Filename contains invalid path sequence " + fileName);
						}
						String productfilename = bannerDao.getBannerCode() + "_" + fileName
								+ fileName.substring(fileName.lastIndexOf("."));
						Path targetLocation = fileStorageLocation.resolve(productfilename);
						Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);

						
								String fileDownloadUri = "http://localhost:8085/api"+
								"/home/banner/downloadFile/"+productfilename + "/" + bannerDao.getBannerCode();
//						String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
//								.path(":8085/home/banner/downloadFile/")
//								.path(productfilename + "/" + bannerDao.getBannerCode()).toUriString();

						bannerDao.getBannerImgs().add(new HomeBannerMedia(productfilename, targetLocation.toString(),
								fileDownloadUri, file.getContentType(), file.getSize(), bannerDao));
					} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
						log.error("Banner Service. {}",e.getMessage());
						e.printStackTrace();
					}
					// TODO Auto-generated method stub
				}

			}
			bannerRepo.save(bannerDao);
		}

	}

	@Override
	public BannerDto retriveActiveBanner() {
		// TODO Auto-generated method stub
		BannerDto homeBanner = null;
		HomeBanner banner = bannerRepo.findByIsActive("Y");
		if (banner != null) {
			List<AmiruthamProducts> allprod = productRepo.findAll();
			List<AmiruthamProducts> bestselling = allprod.stream().filter(p -> "Y".equals(p.getProductBestSellingYN()))
					.collect(Collectors.toList());

			List<ProductDto> productlistdto = new ArrayList<ProductDto>();

			for (AmiruthamProducts prod : bestselling) {
				List<ProductMediaDto> mediaarray = null;
				List<ProductVarientDto> productVarient = null;
				if (null != prod.getProdMedias() && prod.getProdMedias().size() > 0) {
					mediaarray = prod.getProdMedias().stream()
							.map(prodmed -> new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
									prodmed.getProdImgPath(), prodmed.getProdImgUrl(), prodmed.getProdImgType(),
									prodmed.getProdImgSize(), prodmed.getProductCode()))
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
				ProductDto prodDto = new ProductDto(prod.getId(), prod.getCategory().getId(), prod.getProductCode(),
						prod.getProductNm(), prod.getProductDesc(), prod.getProductuses(), prod.getProductincredience(),
						mediaarray, productVarient, prod.getProductBestSellingYN(), prod.getProductRating(),
						prod.getNoofReviews());
				prodDto.setUpdatedBy(prod.getUpdatedBy());
				prodDto.setCreatedTs(prod.getCreatedTs());
				productlistdto.add(prodDto);

			}

			homeBanner = ((BannerDto) AmirthumUtills.convertToDto(banner, BannerDto.class, modelMapper));
			homeBanner.setBestselling(productlistdto);

		}
		return (homeBanner);

	}

	@Override
	public BannerDto retribeBannerByID(int id) {
		// TODO Auto-generated method stub
		BannerDto homeBanner = null;
		Optional<HomeBanner> bannerDao = bannerRepo.findById(id);
		if (bannerDao.isPresent()) {
			List<AmiruthamProducts> allprod = productRepo.findAll();
			List<AmiruthamProducts> bestselling = allprod.stream().filter(p -> "Y".equals(p.getProductBestSellingYN()))
					.collect(Collectors.toList());

			List<ProductDto> productlistdto = new ArrayList<ProductDto>();

			for (AmiruthamProducts prod : bestselling) {
				List<ProductMediaDto> mediaarray = null;
				List<ProductVarientDto> productVarient = null;
				if (null != prod.getProdMedias() && prod.getProdMedias().size() > 0) {
					mediaarray = prod.getProdMedias().stream()
							.map(prodmed -> new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
									prodmed.getProdImgPath(), prodmed.getProdImgUrl(), prodmed.getProdImgType(),
									prodmed.getProdImgSize(), prodmed.getProductCode()))
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
				ProductDto prodDto = new ProductDto(prod.getId(), prod.getCategory().getId(), prod.getProductCode(),
						prod.getProductNm(), prod.getProductDesc(), prod.getProductuses(), prod.getProductincredience(),
						mediaarray, productVarient, prod.getProductBestSellingYN(), prod.getProductRating(),
						prod.getNoofReviews());
				prodDto.setUpdatedBy(prod.getUpdatedBy());
				prodDto.setCreatedTs(prod.getCreatedTs());
				productlistdto.add(prodDto);

			}

			homeBanner = ((BannerDto) AmirthumUtills.convertToDto(bannerDao.get(), BannerDto.class, modelMapper));
			homeBanner.setBestselling(productlistdto);
		}
		return (homeBanner);
	}

	@Override
	public Resource loadBannerAsResource(String fileName, String bannerCode) {
		try {
			fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator + bannerCode + File.separator)
					.toAbsolutePath().normalize();
			Path filePath = fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			log.error("Banner Service. {}",ex.getMessage());
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}

	@Override
	public Resource loadEmailTemplateResource(String fileName, String templateCode) {
		try {
			fileStorageLocation = Paths
					.get(Upload_Path + "EmailTemplate" + File.separator + templateCode + File.separator)
					.toAbsolutePath().normalize();
			Path filePath = fileStorageLocation.resolve(fileName).normalize();
			Resource resource = new UrlResource(filePath.toUri());
			if (resource.exists()) {
				return resource;
			} else {
				throw new MyFileNotFoundException("File not found " + fileName);
			}
		} catch (MalformedURLException ex) {
			log.error("Banner Service. {}",ex.getMessage());
			throw new MyFileNotFoundException("File not found " + fileName, ex);
		}
	}

	@Override
	public void deleteBannerByID(int id) {
		// TODO Auto-generated method stub
		bannerRepo.deleteById(id);

	}

	@Override
	public void addHomecontactreference(CustomerNewsLetterDto contactus) {
		// TODO Auto-generated method stub

		newsLetterRepository.save(new CustomerNewsLetter(contactus.getEmail(), "Guest"));

	}

	@Override
	public List<BannerDto> retriveAllBanners() {// TODO Auto-generated method stub
		List<BannerDto> homeBannerList = new ArrayList<BannerDto>();
		List<HomeBanner> bannerDaoList = bannerRepo.findAll();
		if (bannerDaoList != null) {
			List<AmiruthamProducts> allprod = productRepo.findAll();
			List<AmiruthamProducts> bestselling = allprod.stream().filter(p -> "Y".equals(p.getProductBestSellingYN()))
					.collect(Collectors.toList());

			List<ProductDto> productlistdto = new ArrayList<ProductDto>();

			for (AmiruthamProducts prod : bestselling) {
				List<ProductMediaDto> mediaarray = null;
				List<ProductVarientDto> productVarient = null;
				if (null != prod.getProdMedias() && prod.getProdMedias().size() > 0) {
					mediaarray = prod.getProdMedias().stream()
							.map(prodmed -> new ProductMediaDto(prodmed.getId(), prodmed.getProdImgNm(),
									prodmed.getProdImgPath(), prodmed.getProdImgUrl(), prodmed.getProdImgType(),
									prodmed.getProdImgSize(), prodmed.getProductCode()))
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
				ProductDto prodDto = new ProductDto(prod.getId(), prod.getCategory().getId(), prod.getProductCode(),
						prod.getProductNm(), prod.getProductDesc(), prod.getProductuses(), prod.getProductincredience(),
						mediaarray, productVarient, prod.getProductBestSellingYN(), prod.getProductRating(),
						prod.getNoofReviews());
				prodDto.setUpdatedBy(prod.getUpdatedBy());
				prodDto.setCreatedTs(prod.getCreatedTs());
				productlistdto.add(prodDto);

			}

			for (HomeBanner banner : bannerDaoList) {
				BannerDto homeBanner = ((BannerDto) AmirthumUtills.convertToDto(banner, BannerDto.class, modelMapper));
				homeBanner.setBestselling(productlistdto);
				homeBannerList.add(homeBanner);
			}

		}
		return (homeBannerList);
	}

}
