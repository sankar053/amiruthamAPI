/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;

/**
 * @author sanka
 *
 */
@Data
public class CategoryDto {
	

	private Integer id;
	
	private String categoryCd;
	
	private String categoryNm;
	
	private String categoryDesc;
	
   private Set<ProductDto> products = new HashSet<>();
	

}
