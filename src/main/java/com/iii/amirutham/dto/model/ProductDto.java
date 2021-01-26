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

	private String productCode;

	private String productBrand;

	private String productCategoryCode;

	private String productNm;

	private String productDesc;

	private String productuses;

	private String productspec;

	private String productincredience;

	private String productHighlight;

	private String productBestSellingYN;

	private boolean available;

	private List<ProductMediaDto> prodMedias;

	private List<ProductVarientDto> prodVarient;
	
	private Float productRating= Float.valueOf(0);
	
	private Integer noofReviews;

	@NotNull
	private Integer categoryid;

	private String bestSelling;

	private List<Object> bannerImg;

	public ProductDto(Integer id, @NotNull Integer categoryid, String productCode, @NotNull String productNm,
			@NotNull String productDesc, @NotNull String productuses, String productincredience,
			List<ProductMediaDto> prodMedias, List<ProductVarientDto> prodVarient, String bestSelling,Float productRating,Integer noofReviews) {
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
		this.bestSelling = "Y".equals(bestSelling) ? "true" : "false";
		this.productRating=(null!=productRating ? productRating : Float.valueOf(0));
		this.noofReviews=noofReviews;
	}

}
