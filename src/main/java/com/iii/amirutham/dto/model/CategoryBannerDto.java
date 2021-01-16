/**
 * 
 */
package com.iii.amirutham.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CategoryBannerDto extends BaseEntityDto {
	
	private Integer id;


	private String bannerFileNm;

	private String bannerFilepth;

	private String bannerImgUrl;

	private String bannerImgType;

	private Long bannerImgSize;

}
