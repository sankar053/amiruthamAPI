/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
public class BannerDto extends BaseEntityDto {

	private Integer id;

	
	private String bannerName;
	private String bannerCode;

	private String bannerDesc;
	
	private String instaLink;
	
	private String youtubeLink;
	
	private String facebookLink;
	
	private String whatsappLink;
	
	private List<ProductDto> bestselling;
	private List<Object> bannerImg;
	
	private List<BannerMediaDto> bannerImgs;

}
