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
	private Integer categoryid;
	
	private String productCode;
	
	@NotNull
	private String productNm;
	
	@NotNull
	private String productDesc;
	
	@NotNull
	private String productuses;
	
	private String productincredience;
	
	private List<Object> bannerImg;
	
	List<ProductMediaDto> prodMedias;
	List<ProductVarientDto> prodVarient;
	public ProductDto(Integer id, @NotNull Integer categoryid, String productCode, @NotNull String productNm,
			@NotNull String productDesc, @NotNull String productuses, String productincredience,
			List<ProductMediaDto> prodMedias, List<ProductVarientDto> prodVarient) {
		super();
		this.id = id;
		this.categoryid = categoryid;
		this.productCode = productCode;
		this.productNm = productNm;
		this.productDesc = productDesc;
		this.productuses = productuses;
		this.productincredience = productincredience;
		this.prodMedias = prodMedias;
		this.prodVarient = prodVarient;
	}
	
	
	
   
}
