/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.model.HomeBannerMedia;
import com.iii.amirutham.model.product.CategoryBanner;
import com.iii.amirutham.model.product.ProductMediaGallary;
import com.iii.amirutham.repo.BannerRepository;
import com.iii.amirutham.service.DeleteMediaService;

/**
 * @author sanka
 *
 */
@Service
public class DeleteMediaServiceImpl implements DeleteMediaService {

	@Autowired
	private BannerRepository bannerRepository;

	@Override
	public void DeleteMediaHomeBanner(Integer id) {
		// TODO Auto-generated method stub
		HomeBannerMedia media = bannerRepository.getSelectedHomeBannerImg(id);
		if (media != null) {

			try {
				boolean result = Files.deleteIfExists(Paths.get(media.getBannerFilepth()));
				if (result) {
					System.out.println("File is deleted!");
				} else {
					System.out.println("Sorry, unable to delete the file.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			bannerRepository.deleteSelectedHomeBannerImg(id);

		}

	}

	@Override
	public void DeleteMediaCategoryBanner(Integer id) {
		// TODO Auto-generated method stub

		CategoryBanner media = bannerRepository.getSelectedCategoryBannerImg(id);
		if (media != null) {

			try {
				boolean result = Files.deleteIfExists(Paths.get(media.getBannerFilepth()));
				if (result) {
					System.out.println("File is deleted!");
				} else {
					System.out.println("Sorry, unable to delete the file.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			bannerRepository.deleteCategoryBanner(id);

		}

	}

	@Override
	public void DeleteMediaProduct(Integer id) {
		// TODO Auto-generated method stub
		ProductMediaGallary media = bannerRepository.getSelectedProductBannerImg(id);
		if (media != null) {

			try {
				boolean result = Files.deleteIfExists(Paths.get(media.getProdImgPath()));
				if (result) {
					System.out.println("File is deleted!");
				} else {
					System.out.println("Sorry, unable to delete the file.");
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
			bannerRepository.deleteProductImage(id);

		}
	
	}

}
