package com.iii.amirutham.controller.payment;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.PaymentFailureDto;
import com.iii.amirutham.dto.model.PaymentSuccesDto;

public interface PaymentService {
	
	
	public GenericResponse createOrderWothRazorPay(PaymentRequest payreq);
	
	public GenericResponse createInvoice(PaymentRequest payreq);
	
	public GenericResponse capturePayment(PaymentRequest payreq);
	
	public GenericResponse getPaymentSuccessDetails(PaymentSuccesDto payreq);
	
	public GenericResponse getPaymentFailureDetails(PaymentFailureDto payreq);

	public GenericResponse initiaterefund(String paymentId);

}
