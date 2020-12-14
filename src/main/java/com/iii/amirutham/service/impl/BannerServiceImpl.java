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
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import com.iii.amirutham.dto.model.BannerDto;
import com.iii.amirutham.exception.FileStorageException;
import com.iii.amirutham.exception.MyFileNotFoundException;
import com.iii.amirutham.model.HomeBanner;
import com.iii.amirutham.repo.BannerRepository;
import com.iii.amirutham.service.BannerService;
import com.iii.amirutham.utills.AmirthumUtills;

/**
 * @author sanka
 *
 */
@Service
public class BannerServiceImpl implements BannerService {

	@Autowired
	private BannerRepository bannerRepo;
	@Value("${amirthum.file.upload-dir}")
	private String Upload_Path;

	private Path fileStorageLocation;

	@Override
	public HomeBanner addHomeBanner(String payload, MultipartFile file) {

		BannerDto bannerdto = (BannerDto) AmirthumUtills.convertJsontoObject(BannerDto.class, payload);
		HomeBanner bannerDao = new HomeBanner();
		fileStorageLocation = Paths.get(Upload_Path + "Banner"+File.separator).toAbsolutePath().normalize();
		try {
			Files.createDirectories(fileStorageLocation.getParent());
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		if (null != bannerdto) {

			bannerDao.setBannerName(bannerdto.getBannerName());
			bannerDao.setBannerDesc(bannerdto.getBannerDesc());

			if (null != file) {

				try {
					AmirthumUtills.makeaDirectory(fileStorageLocation);
					String fileName = StringUtils.cleanPath(file.getOriginalFilename());
					if (fileName.contains("..")) {
						throw new FileStorageException("Sorry! Filename contains invalid path sequence " + fileName);
					}
					Path targetLocation = fileStorageLocation.resolve(fileName);

					Files.copy(file.getInputStream(), targetLocation, StandardCopyOption.REPLACE_EXISTING);
					bannerDao.setBannerFileNm(fileName);
					bannerDao.setBannerFilepth(targetLocation.toString());
					bannerDao.setBannerImgSize(file.getSize());
					bannerDao.setBannerImgType(file.getContentType());
					String fileDownloadUri = ServletUriComponentsBuilder.fromCurrentContextPath()
							.path("/banner/downloadFile/").path(fileName).toUriString();

					bannerDao.setBannerImgUrl(fileDownloadUri);
					return bannerRepo.save(bannerDao);
				} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }
					e.printStackTrace();
				}
				// TODO Auto-generated method stub

			}

		}
		return bannerDao;

	}

	@Override
	public List<HomeBanner> retriveAllBanners() {
		// TODO Auto-generated method stub
		return bannerRepo.findAll();
	}

	@Override
	public Optional<HomeBanner> retribeBannerByID(int id) {
		// TODO Auto-generated method stub
		return bannerRepo.findById(id);
	}

	@Override
	public Resource loadBannerAsResource(String fileName) {
		try {
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
