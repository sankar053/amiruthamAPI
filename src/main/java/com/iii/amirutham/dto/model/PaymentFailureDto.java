/**
 * 
 */
package com.iii.amirutham.dto.model;

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
public class PaymentFailureDto {
	
	private String errorCode;
	
	private String errorDescription;
	
	private String errorStep;
	
	private String errorSource;
	
	private String errorReason;
	
	private String errorPaymentId;

}
