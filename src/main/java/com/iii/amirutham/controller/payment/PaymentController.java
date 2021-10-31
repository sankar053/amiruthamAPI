/**
 * 
 */
package com.iii.amirutham.controller.payment;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.model.PaymentSuccesDto;

/**
 * @author admin
 *
 */
@RestController
@RequestMapping("/payment/")
public class PaymentController {
	
   @Autowired
   private PaymentService paymentService;
	
	@PostMapping("creation")
	public ResponseEntity<?> createPayment(@RequestBody PaymentRequest payReq){
		paymentService.createOrderWothRazorPay(payReq);
		
		return ResponseEntity.ok("Order Created in Razorpay");
	}
	
	@PostMapping("invoice")
	public ResponseEntity<?> createInvoice(@RequestBody PaymentRequest payReq){
		paymentService.createInvoice(payReq);
		
		return ResponseEntity.ok("invoice Created in Razorpay");
	}
	
	@PostMapping("capture")
	public ResponseEntity<?> capturePayment(@RequestBody PaymentRequest payReq){
		paymentService.capturePayment(payReq);
		return ResponseEntity.ok("Payment captured in Razorpay");
	}
	
	
	@PostMapping("success")
	public ResponseEntity<?> getSuccessTransaction(@RequestBody PaymentSuccesDto paymentSuccessReq){
		paymentService.getPaymentSuccessDetails(paymentSuccessReq);
		return ResponseEntity.ok("Payment Success in Razorpay");
	}
	
	@GetMapping("refund/{paymentId}")
	public ResponseEntity<?> initiateRefundTransaction(@PathVariable(name = "paymentId") String paymentId){
		paymentService.initiaterefund(paymentId);
		return ResponseEntity.ok("Refund Success in Razorpay");
	}

}
