package com.iii.amirutham.dto.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSuccesDto{
	
	private String razorPayOrderId;
	
	private String razorPayPaymentId;
	
	private String razorPaySignature;

}
