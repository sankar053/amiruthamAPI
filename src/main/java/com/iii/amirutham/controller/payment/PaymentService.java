package com.iii.amirutham.controller.payment;

import com.iii.amirutham.dto.model.PaymentSuccesDto;
import com.razorpay.Order;

public interface PaymentService {
	
	
	public Order createOrderWothRazorPay(PaymentRequest payreq);
	
	public void createInvoice(PaymentRequest payreq);
	
	public void capturePayment(PaymentRequest payreq);
	
	public void getPaymentSuccessDetails(PaymentSuccesDto payreq);

	public void initiaterefund(String paymentId);

}
