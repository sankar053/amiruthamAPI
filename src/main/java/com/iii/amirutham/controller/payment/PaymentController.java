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

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.PaymentFailureDto;
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
	public ResponseEntity<?> createPayment(@RequestBody PaymentRequest payReq) {
		GenericResponse response = paymentService.createOrderWothRazorPay(payReq);

		return ResponseEntity.ok(response);
	}

	@PostMapping("invoice")
	public ResponseEntity<?> createInvoice(@RequestBody PaymentRequest payReq) {
		GenericResponse response = paymentService.createInvoice(payReq);

		return ResponseEntity.ok(response);
	}

	@PostMapping("capture")
	public ResponseEntity<?> capturePayment(@RequestBody PaymentRequest payReq) {
		GenericResponse response = paymentService.capturePayment(payReq);
		return ResponseEntity.ok(response);
	}

	@PostMapping("success")
	public ResponseEntity<?> getSuccessTransaction(@RequestBody PaymentSuccesDto paymentSuccessReq) {
		GenericResponse response = paymentService.getPaymentSuccessDetails(paymentSuccessReq);
		return ResponseEntity.ok(response);
	}

	@PostMapping("failed")
	public ResponseEntity<?> getFailedTransaction(@RequestBody PaymentFailureDto paymentSuccessReq) {
		GenericResponse response = paymentService.getPaymentFailureDetails(paymentSuccessReq);
		return ResponseEntity.ok(response);
	}

	@GetMapping("refund/{paymentId}")
	public ResponseEntity<?> initiateRefundTransaction(@PathVariable(name = "paymentId") String paymentId) {
		GenericResponse response = paymentService.initiaterefund(paymentId);
		return ResponseEntity.ok(response);
	}

}
