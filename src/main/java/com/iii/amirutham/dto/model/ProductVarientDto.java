/**
 * 
 */
package com.iii.amirutham.dto.model;

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
public class ProductVarientDto {

	private Integer id;

	@NotNull
	private Double maximumRetailPrice;

	private Double sellingPrice;

	private Double savedPrice;

	@NotNull
	private Integer discount;

	@NotNull
	private Integer unit;

	@NotNull
	private String unitType;

	@NotNull
	private String manufactureDate;

	@NotNull
	private String bestBeforeDate;

	@NotNull
	private int prodid;

}
