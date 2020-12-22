/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.List;

import com.iii.amirutham.model.product.AmiruthamProducts;

import lombok.Data;

/**
 * @author sanka
 *
 */
@Data
public class BannerDto {

	private Integer id;

	
	private String bannerName;

	private String bannerDesc;
	
	private String instaLink;
	
	private String youtubeLink;
	
	private String facebookLink;
	
	private String twitterLink;
	
	private List<AmiruthamProducts> bestselling;

}
