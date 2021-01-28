/**
 * 
 */
package com.iii.amirutham.common.mail.dto;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
@AllArgsConstructor
public class OrderItemsMail {
	
	private String productName;
	
	private Integer productQuantity;
	
	private BigDecimal productPrice;

}
