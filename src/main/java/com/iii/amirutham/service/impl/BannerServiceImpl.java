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
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iii.amirutham.dto.model.BannerDto;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.exception.FileStorageException;
import com.iii.amirutham.exception.MyFileNotFoundException;
import com.iii.amirutham.model.HomeBanner;
import com.iii.amirutham.model.HomeBannerMedia;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.repo.BannerRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.service.BannerService;
import com.iii.amirutham.service.SequenceService;
import com.iii.amirutham.utills.AmirthumUtills;

/**
 * @author sanka
 *
 */
@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerRepository bannerRepo;

	@Autowired
	private ProductRepository productRepo;

	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private SequenceService seqservice;

	@Value("${amirthum.file.upload-dir}")
	private String Upload_Path;

	private Path fileStorageLocation;

	@Override
	public BannerDto addHomeBanner(BannerDto bannerdto, List<MultipartFile> files) {

		HomeBanner bannerDao = new HomeBanner();
		fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator).toAbsolutePath().normalize();
		try {
			Files.createDirectories(fileStorageLocation.getParent());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
			bannerDao.setBannerName(bannerdto.getBannerName());
			SequnceDto sequence = seqservice.findMySeQuence("BANNER");
			bannerDao.setBannerCode(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			bannerDao.setBannerDesc(bannerdto.getBannerDesc());
			bannerDao.setInstaLink(bannerdto.getInstaLink());
			bannerDao.setFacebookLink(bannerdto.getFacebookLink());
			bannerDao.setYoutubeLink(bannerdto.getYoutubeLink());
			bannerDao.setWhatsappLink(bannerdto.getWhatsappLink());
			List<HomeBannerMedia> mediaArray = new ArrayList<HomeBannerMedia>();
			if (null != files) {
				int filecount=0;
				for (MultipartFile file : files) {

					try {
						String fileName = StringUtils.cleanPath(file.getOriginalFilename());
						if (fileName.contains("..")) {
							throw new FileStorageException(
									"Sorry! Filename contains invalid path sequence " + fileName);
						}
						String productfilename =bannerDao.getBannerCode()+"_"+filecount+++fileName.substring(fileName.lastIndexOf("."));
						Path targetLocation = fileStorageLocation.resolve(productfilename);
						Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
						
						String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
								.path("/banner/downloadFile/").path(productfilename+"/"+bannerDao.getBannerCode()).toUriString();

						mediaArray.add(new HomeBannerMedia(productfilename, targetLocation.toString(), fileDownloadUri,
								file.getContentType(), file.getSize()));
					} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
						e.printStackTrace();
					}
					// TODO Auto-generated method stub
				}
				bannerDao.setBannerImgs(mediaArray);
				bannerDao=bannerRepo.save(bannerDao);
			}

		
		List<AmiruthamProducts> allprod = productRepo.findAll();
		List<AmiruthamProducts> bestselling = allprod.stream().filter(p -> "Y".equals(p.getProductBestSellingYN()))
				.collect(Collectors.toList());
		BannerDto homeBanner = ((BannerDto) AmirthumUtills.convertToDto(bannerDao, BannerDto.class, modelMapper));
		homeBanner.setBestselling(bestselling);
		return (homeBanner);

	}
	
	@Override
	public BannerDto updateHomeBanner(BannerDto bannerdto, List<MultipartFile> files) {
		// TODO Auto-generated method stub


		HomeBanner bannerDao = new HomeBanner();
		fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator).toAbsolutePath().normalize();
	
		bannerDao.setId(bannerdto.getId());
			bannerDao.setBannerName(bannerdto.getBannerName());
			SequnceDto sequence = seqservice.findMySeQuence("BANNER");
			bannerDao.setBannerCode(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			bannerDao.setBannerDesc(bannerdto.getBannerDesc());
			bannerDao.setInstaLink(bannerdto.getInstaLink());
			bannerDao.setFacebookLink(bannerdto.getFacebookLink());
			bannerDao.setYoutubeLink(bannerdto.getYoutubeLink());
			bannerDao.setWhatsappLink(bannerdto.getWhatsappLink());
			List<HomeBannerMedia> mediaArray = new ArrayList<HomeBannerMedia>();
			if (null != files) {
				int filecount=0;
				for (MultipartFile file : files) {

					try {
						String fileName = StringUtils.cleanPath(file.getOriginalFilename());
						if (fileName.contains("..")) {
							throw new FileStorageException(
									"Sorry! Filename contains invalid path sequence " + fileName);
						}
						String productfilename =bannerDao.getBannerCode()+"_"+filecount+++fileName.substring(fileName.lastIndexOf("."));
						Path targetLocation = fileStorageLocation.resolve(productfilename);
						Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
						
						String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
								.path("/banner/downloadFile/").path(productfilename+"/"+bannerDao.getBannerCode()).toUriString();

						mediaArray.add(new HomeBannerMedia(productfilename, targetLocation.toString(), fileDownloadUri,
								file.getContentType(), file.getSize()));
					} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
						e.printStackTrace();
					}
					// TODO Auto-generated method stub
				}
				bannerDao.setBannerImgs(mediaArray);
				bannerDao=bannerRepo.save(bannerDao);
			}
		List<AmiruthamProducts> allprod = productRepo.findAll();
		List<AmiruthamProducts> bestselling = allprod.stream().filter(p -> "Y".equals(p.getProductBestSellingYN()))
				.collect(Collectors.toList());
		BannerDto homeBanner = ((BannerDto) AmirthumUtills.convertToDto(bannerDao, BannerDto.class, modelMapper));
		homeBanner.setBestselling(bestselling);
		return (homeBanner);

	
	}

	@Override
	public BannerDto retriveAllBanners() {
		// TODO Auto-generated method stub
		BannerDto homeBanner=null;
		List<HomeBanner> bannerList = bannerRepo.findAll();
		if(bannerList!=null && bannerList.size()>0) {
		List<AmiruthamProducts> allprod = productRepo.findAll();
		List<AmiruthamProducts> bestselling = allprod.stream().filter(p -> "Y".equals(p.getProductBestSellingYN()))
				.collect(Collectors.toList());
		homeBanner = ((BannerDto) AmirthumUtills.convertToDto(bannerList.get(0), BannerDto.class, modelMapper));
		homeBanner.setBestselling(bestselling);
		}
		return (homeBanner);
		
	}

	@Override
	public BannerDto retribeBannerByID(int id) {
		// TODO Auto-generated method stub
		BannerDto homeBanner=null;
		Optional<HomeBanner> bannerDao = bannerRepo.findById(id);
		if(bannerDao.isPresent()) {
			List<AmiruthamProducts> allprod = productRepo.findAll();
			List<AmiruthamProducts> bestselling = allprod.stream().filter(p -> "Y".equals(p.getProductBestSellingYN()))
					.collect(Collectors.toList());
			homeBanner = ((BannerDto) AmirthumUtills.convertToDto(bannerDao.get(), BannerDto.class, modelMapper));
			homeBanner.setBestselling(bestselling);	
		}
		return (homeBanner);
	}

	@Override
	public Resource loadBannerAsResource(String fileName) {
		try {
			fileStorageLocation = Paths.get(Upload_Path + "Banner" + File.separator).toAbsolutePath().normalize();
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
