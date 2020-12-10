/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author sanka
 *
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
	

	private Integer id;
	
	private String categoryid;
	
	private String productCode;
		
	private String productNm;
	
	private String productDesc;
	
	private String productuses;
	
	List<ProductMediaDto> prodMedias;
	List<ProductVarientDto> prodVarient;
	
   
}
