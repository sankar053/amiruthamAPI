/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.ArrayList;
import java.util.List;

import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class CategoryDto extends BaseEntityDto{
	

	private Integer id;
	
	private String categoryCd;
	
	private String categoryNm;
	
	private String categoryDesc;
	
	private String categoryBannerImgURL;
	
	@NotNull
	private Integer categoryOrder;
	
   //@JsonIgnore
   private List<ProductDto> products = new ArrayList();
	

}
