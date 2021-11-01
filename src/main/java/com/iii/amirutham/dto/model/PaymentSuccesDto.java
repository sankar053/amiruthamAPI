package com.iii.amirutham.dto.model;

import javax.validation.constraints.NotBlank;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSuccesDto{
	
	@NotBlank
	private String razorPayOrderId;
	
	@NotBlank
	private String razorPayPaymentId;
	
	private String razorPaySignature;

}
