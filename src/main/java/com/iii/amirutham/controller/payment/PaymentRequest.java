/**
 * 
 */
package com.iii.amirutham.controller.payment;

import java.math.BigDecimal;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author admin
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentRequest {
	
	private String amirthumorderRef;
	
	private Integer amirthumorderId;
	
	private BigDecimal amount;
	
	private String currency="INR";
	
	private String invoiceName;

}
