/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.BannerDto;

/**
 * @author sanka
 *
 */
public interface BannerService {

	public BannerDto addHomeBanner(BannerDto bannerDto, List<MultipartFile> file);
	
	public BannerDto updateHomeBanner(BannerDto bannerDto, List<MultipartFile> file);

	public BannerDto retriveAllBanners();

	public BannerDto retribeBannerByID(int id);

	public Resource loadBannerAsResource(String fileName);

}
