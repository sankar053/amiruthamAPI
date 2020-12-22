/**
 * 
 */
package com.iii.amirutham.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.BannerDto;

/**
 * @author sanka
 *
 */
public interface BannerService {

	public BannerDto addHomeBanner(String payload, MultipartFile files);

	public BannerDto retriveAllBanners();

	public BannerDto retribeBannerByID(int id);

	public Resource loadBannerAsResource(String fileName);

}
