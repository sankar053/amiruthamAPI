    /**
 * 
 */
package com.iii.amirutham.dto.model;

import java.math.BigDecimal;
import java.util.Set;

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
public class CartDto extends BaseEntity {

	private Integer id;

	private String shoppingCartCode;

	private Set<CartItemDto> lineItems ;//= new HashSet<CartItemDto>();

	private AddditionalChargesDto charges;

	private Integer customerId;

	private Integer orderId;

	private String shoppingCartStatus;
	
	private BigDecimal finalpriceWithoutTax;
	
	private BigDecimal finalpriceWithTax;

}
