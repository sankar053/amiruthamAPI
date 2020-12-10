/**
 * 
 */
package com.iii.amirutham.model.product;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity
@Table(name = "PRODUCT_VARIENT")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ProductVarient {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column
	private Integer id;

   	@Column(name="PROD_MRP_PRICE")
	private Double maximumRetailPrice;
	
   	@Column(name="PROD_SELLING_PRICE")
	private Double sellingPrice;
   	
   	@Column(name="PROD_SAVED_PRICE")
	private Double savedPrice;
   	
	@Column(name="PROD_DISCOUNT_RATE")
	private Integer discount;
	
	@Column(name="PROD_IN_UNIT")
	private Integer unit;
	
	@Column(name="PROD_UNIT_TYPE")
	private String unitType;
	
	@Column(name="PROD_MANUFACTURE_DATE")
	private String manufactureDate;
	
	@Column(name="PROD_USEBY_DATE")
	private String bestBeforeDate;

}
