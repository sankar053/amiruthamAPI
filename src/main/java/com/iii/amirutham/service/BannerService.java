/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;
import java.util.Optional;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.model.HomeBanner;

/**
 * @author sanka
 *
 */
public interface BannerService {

	HomeBanner addHomeBanner(String payload, MultipartFile files);

	List<HomeBanner> retriveAllBanners();

	Optional<HomeBanner> retribeBannerByID(int id);

	Resource loadBannerAsResource(String fileName);

}
