package com.iii.amirutham.dto.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMediaDto  {
	
	

	private Integer id;
	
	private String prodImgNm;
		
	private String prodImgPath;
	
	private String prodImgUrl;
	
	private String prodImgType;

	private Long prodImgSize;


	

}
