package com.iii.amirutham.model.product;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "PRODUCT_MEDIA_GALLARY")
@Data
/*
 * @AllArgsConstructor
 * 
 * @NoArgsConstructor
 */
public class ProductMediaGallary {
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	
	private String prodImgNm;
		
	private String prodImgPath;
	
	private String prodImgurl;

	public ProductMediaGallary(String prodImgNm, String prodImgPath, String prodImgurl) {
		super();
		this.prodImgNm = prodImgNm;
		this.prodImgPath = prodImgPath;
		this.prodImgurl = prodImgurl;
	}

	public ProductMediaGallary() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
	

}
