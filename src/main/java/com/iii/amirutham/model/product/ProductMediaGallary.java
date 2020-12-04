package com.iii.amirutham.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "PRODUCT_MEDIA_GALLARY")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductMediaGallary extends BaseEntity{
	
	
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PROD_MED_ID")
	private Integer id;
	
	@Column(name = "PROD_MED_NM")
	private String prodImgNm;
	
	@Column(name = "PROD_MED_FILE_PATH")
	private String prodImgPath;
	
	@Column(name = "PROD_MED_URL")
	private String prodImgurl;

	public ProductMediaGallary(String prodImgNm, String prodImgPath, String prodImgurl) {
		super();
		this.prodImgNm = prodImgNm;
		this.prodImgPath = prodImgPath;
		this.prodImgurl = prodImgurl;
	}


	
	

}
