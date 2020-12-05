/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;
import java.util.Optional;

import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.model.HomeBanner;

/**
 * @author sanka
 *
 */
public interface BannerService {

	void addHomeBanner(String payload, MultipartFile files);

	List<HomeBanner> retriveAllBanners();

	Optional<HomeBanner> retribeBannerByID(int id);

}
