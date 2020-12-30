/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.util.List;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto extends BaseEntityDto {
	

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
	
	List<ProductMediaDto> prodMedias;
	List<ProductVarientDto> prodVarient;
	
   
}
