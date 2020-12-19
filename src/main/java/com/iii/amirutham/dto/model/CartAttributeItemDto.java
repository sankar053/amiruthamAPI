/**
 * 
 */
package com.iii.amirutham.dto.model;

import com.iii.amirutham.model.BaseEntity;

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
public class CartAttributeItemDto extends BaseEntity {

	private Integer cartAttributeId;

	private Double maximumRetailPrice;

	private Double sellingPrice;

	private Double savedPrice;

	private Integer discount;

	private Integer unit;

	private String unitType;

	private String prodCode;

	private String manufactureDate;

	private String bestBeforeDate;

}
