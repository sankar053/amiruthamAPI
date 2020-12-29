package com.iii.amirutham.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductMediaDto  extends BaseEntityDto{
	
	

	private Integer id;
	
	private String prodImgNm;
		
	private String prodImgPath;
	
	private String prodImgUrl;
	
	private String prodImgType;

	private Long prodImgSize;


	

}
