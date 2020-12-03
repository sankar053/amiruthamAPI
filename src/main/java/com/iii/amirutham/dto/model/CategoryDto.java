/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.ArrayList;
import java.util.List;

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
	
   private List<ProductDto> products = new ArrayList();
	

}
