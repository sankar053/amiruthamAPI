/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.BannerDto;
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

	@Override
	public void addHomeBanner(String payload, MultipartFile file) {

		BannerDto bannerdto = (BannerDto) AmirthumUtills.convertJsontoObject(BannerDto.class, payload);

		if (null != bannerdto) {
			HomeBanner bannerDao = new HomeBanner();
			bannerDao.setBannerName(bannerdto.getBannerName());
			bannerDao.setBannerDesc(bannerdto.getBannerDesc());

			if (null != file) {

				try {

					byte[] bytes = file.getBytes();
					Path path = Paths.get("C:\\catalogs\\" + file.getOriginalFilename());
					Files.write(path, bytes);
					bannerDao.setBannerFileNm(file.getOriginalFilename());
					bannerDao.setBannerFilepth("C:\\catalogs\\" + file.getOriginalFilename());

				} catch (IOException e) { // TODO Auto-generated catch block e.printStackTrace(); }

				}
				// TODO Auto-generated method stub

			}

			bannerRepo.save(bannerDao);
		}

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

}
