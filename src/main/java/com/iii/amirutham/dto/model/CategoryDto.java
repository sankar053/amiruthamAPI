/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
public class CategoryDto {
	

	private Integer id;
	
	private String categoryCd;
	
	private String categoryNm;
	
	private String categoryDesc;
	
	private Integer categoryOrder;
	
   //@JsonIgnore
   private List<ProductDto> products = new ArrayList();
	

}
