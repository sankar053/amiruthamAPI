/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

import com.iii.amirutham.dto.model.BannerDto;
import com.iii.amirutham.dto.model.CustomerNewsLetterDto;

/**
 * @author sanka
 *
 */
public interface BannerService {

	public void addHomeBanner(BannerDto bannerDto, List<MultipartFile> file);
	
	public void updateHomeBanner(BannerDto bannerDto, List<MultipartFile> file);

	public  List<BannerDto> retriveAllBanners();

	public BannerDto retribeBannerByID(int id);

	public Resource loadBannerAsResource(String fileName,String bannerCode);

	public void deleteBannerByID(int id);

	public void addHomecontactreference(CustomerNewsLetterDto contactus);

	Resource loadEmailTemplateResource(String fileName, String templateCode);

}
