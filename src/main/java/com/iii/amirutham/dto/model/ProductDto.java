/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.List;

import javax.validation.constraints.NotNull;

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
	
	@NotNull
	private String categoryid;
	
	private String productCode;
	
	@NotNull
	private String productNm;
	
	@NotNull
	private String productDesc;
	
	@NotNull
	private String productuses;
	
	private String incrediances;
	
	@NotNull
	private Integer stock;
	
	List<ProductMediaDto> prodMedias;
	List<ProductVarientDto> prodVarient;
	
   
}
