package com.iii.amirutham.dto.model;

import com.iii.amirutham.model.BaseEntity;

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
	
	private String prodImgurl;

	public ProductMediaDto(String prodImgNm, String prodImgPath, String prodImgurl) {
		super();
		this.prodImgNm = prodImgNm;
		this.prodImgPath = prodImgPath;
		this.prodImgurl = prodImgurl;
	}
	
	
	

}
