/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.math.BigDecimal;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
public class CartItemDto {

	private Integer productId;

	private Integer quantity;

	private Integer varientId;

	private Integer cartItemid;

	private String productCode;
	
	private String itemName;
	
	private String ItemImgURL;
	
	private String sellerName="Amirum & Oil .co";

	private CartAttributeItemDto attributes;

	private BigDecimal itemPrice;// item final price including all rebates

	private BigDecimal subTotal;// item final price * quantity

	// private FinalPrice finalPrice;//contains price details (raw prices)

}
