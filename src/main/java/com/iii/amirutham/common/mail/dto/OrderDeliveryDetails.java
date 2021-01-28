/**
 * 
 */
package com.iii.amirutham.common.mail.dto;

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
public class OrderDeliveryDetails {
	
	private String receiverName;
	
	private String receiverEmail;
	
	private String receiverPhone;
	
	private String addressline1;
	
	private String dstPin;
	
	private String state;

}
