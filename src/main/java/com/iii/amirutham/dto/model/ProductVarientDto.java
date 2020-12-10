/**
 * 
 */
package com.iii.amirutham.dto.model;

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
public class ProductVarientDto {
	

	private Integer id;

	private Double maximumRetailPrice;

	private Double sellingPrice;

	private Double savedPrice;
   	
	private Integer discount;
	
	private Integer unit;
	
	private String unitType;
	
	private String manufactureDate;
	
	private String bestBeforeDate;
	
	private int prodid;

}
