package com.iii.amirutham.controller.payment;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.dto.base.GenericResponse;
import com.iii.amirutham.dto.model.PaymentFailureDto;
import com.iii.amirutham.dto.model.PaymentSuccesDto;
import com.iii.amirutham.model.PaymentFailure;
import com.iii.amirutham.model.PaymentSuccess;
import com.iii.amirutham.model.TransactionDetails;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.repo.OrderRepository;
import com.iii.amirutham.repo.PaymentFailureRepository;
import com.iii.amirutham.repo.PaymentSuccessRepo;
import com.iii.amirutham.repo.TransactionDetailsRepo;
import com.iii.amirutham.utills.AmirthumUtills;
import com.iii.amirutham.utills.Constant;
import com.razorpay.Invoice;
import com.razorpay.Order;
import com.razorpay.Payment;
import com.razorpay.RazorpayClient;
import com.razorpay.RazorpayException;
import com.razorpay.Refund;

@Service
public class PaymentServiceImpl implements PaymentService {

	@Autowired
	TransactionDetailsRepo transactionRepo;

	@Autowired
	PaymentSuccessRepo raymentSuccessRepo;

	@Autowired
	RazorpayClient razorpayClient;

	@Autowired
	OrderRepository orderRepo;
	
	@Autowired
	private ModelMapper modelMapper;
	
	@Autowired
	private PaymentFailureRepository paymentFailureRepository;

	@Override
	public GenericResponse createOrderWothRazorPay(PaymentRequest payreq) {

		try {

			JSONObject options = new JSONObject();
			 options.put("amount", payreq.getAmount().multiply(new BigDecimal("100")));
			// // Note: The amount should be in paise.
			//options.put("amount", 100);
			options.put("currency", payreq.getCurrency());
			options.put("receipt", payreq.getAmirthumorderRef());
			Order order = razorpayClient.Orders.create(options);

			TransactionDetails transaction = new TransactionDetails(payreq.getAmirthumorderId(), order.get("id"),
					"ORDER", "S");
			transactionRepo.save(transaction);

			return new GenericResponse(Constant.PAYMENT_ORDER_SUCCESS,order);
			// System.out.println(order.toString());

		} catch (RazorpayException e) {
			// TODO Auto-generated catch bltransactionock
			e.printStackTrace();
			TransactionDetails transaction = new TransactionDetails(payreq.getAmirthumorderId(), "", "ORDER", "F");
			transaction.setPaymentErrorReason(e.getMessage());
			transactionRepo.save(transaction);
			return new GenericResponse(Constant.PAYMENT_ORDER_FAIL,"1001");
		} catch (Exception e) {
			e.printStackTrace();
			TransactionDetails transaction = new TransactionDetails(payreq.getAmirthumorderId(), "", "ORDER", "F");
			transaction.setPaymentErrorReason(e.getMessage());
			transactionRepo.save(transaction);
			return new GenericResponse(Constant.PAYMENT_ORDER_FAIL,"1001");
		}
		// TODO Auto-generated method stub
		

	}

	@Override
	public GenericResponse createInvoice(PaymentRequest payreq) {
		// TODO Auto-generated method stub

		try {

			JSONObject lineItem = new JSONObject();
			lineItem.put("amount", payreq.getAmount()); // Note: The amount should be in paise.
			lineItem.put("name", payreq.getInvoiceName());

			JSONArray lineItems = new JSONArray();
			lineItems.put(lineItem);

			JSONObject request = new JSONObject();
			request.put("line_items", lineItems);
			request.put("date", 1480768625); // Timestamp in seconds
			request.put("currency", payreq.getCurrency());
			request.put("sms_notify", "0");

			Invoice invoice = razorpayClient.Invoices.create(request);
			System.out.println(invoice.toJson());
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public GenericResponse capturePayment(PaymentRequest payreq) {
		// TODO Auto-generated method stub

		try {

			JSONObject options = new JSONObject();
			options.put("amount", payreq.getAmount());
			options.put("currency", "INR");
			razorpayClient.Payments.capture("payment_id", options);
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new GenericResponse(Constant.PAYMENT_CAPTURE_FAIL,"1001");
		}
		return null;

	}

	@Override
	public GenericResponse getPaymentSuccessDetails(PaymentSuccesDto payreq) {
		// TODO Auto-generated method stub

		Optional<Orders> orderdao = orderRepo.findByRazorPayOrderReference(payreq.getRazorPayOrderId());
		try {

			Payment payment = razorpayClient.Payments.fetch(payreq.getRazorPayPaymentId());
			if (Boolean.valueOf(payment.get("captured").toString()) && orderdao.isPresent()) {

				Orders order = orderdao.get();
				orderRepo.updateOrderPaymentStatus(payment.get("id"), LocalDateTime.now(),order.getId(),
						payreq.getRazorPayOrderId());
				PaymentSuccess success = new PaymentSuccess();
				success.setPaidAmount(payment.get("amount").toString());
				success.setPaidMethod(payment.get("method"));
				success.setRazororderRef(payment.get("order_id"));
				success.setRazorpaymentId(payment.get("id"));
				success.setRazorResponse(payment.toString());
				success.setRazorStatus(payment.get("status"));
				raymentSuccessRepo.save(success);
				return new GenericResponse(Constant.PAYMENT_SUCCESS);
			}
			return new GenericResponse(Constant.PAYMENT_NOTFOUND);
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return new GenericResponse(Constant.PAYMENT_FAIL,"1001");
		}
		
	}

	@Override
	public GenericResponse initiaterefund(String paymentId) {
		// TODO Auto-generated method stub
		Optional<Orders> orderdao = orderRepo.findByRazorPayTransReference(paymentId);

		if (orderdao.isPresent()) {
			Orders order = orderdao.get();

			try {

				JSONObject refundRequest = new JSONObject();
				refundRequest.put("payment_id", paymentId);
				Refund refund = razorpayClient.Payments.refund(refundRequest);
				System.out.println(refund.toString());
				if ("processed".equalsIgnoreCase(refund.get("status").toString())) {

					orderRepo.updateOrderRefundStatus(refund.get("id"), LocalDateTime.now(), paymentId, order.getId());

					TransactionDetails transaction = new TransactionDetails(order.getId(),
							order.getRazorPayOrderReference(), "REFUND", "S");
					transaction.setPaymentRefundReference(refund.get("id"));
					transaction.setPaymentReference(order.getRazorPayTransReference());
					transactionRepo.save(transaction);
					return new GenericResponse(Constant.PAYMENT_SUCCESS);

				}

			} catch (RazorpayException e) {
				// TODO Auto-generated catch block
				TransactionDetails transaction = new TransactionDetails(order.getId(),
						order.getRazorPayOrderReference(), "REFUND", "F");
				transaction.setPaymentErrorReason(e.getMessage());
				transactionRepo.save(transaction);
				return new GenericResponse(Constant.PAYMENT_REFUND_FAIL,"1001");
			} catch (Exception e) {
				e.printStackTrace();
				TransactionDetails transaction = new TransactionDetails(order.getId(), "", "REFUND", "F");
				transaction.setPaymentErrorReason(e.getMessage());
				transactionRepo.save(transaction);
				return new GenericResponse(Constant.PAYMENT_REFUND_FAIL,"1001");
			}

		}
		return new GenericResponse(Constant.PAYMENT_FAIL);

	}

	@Override
	public GenericResponse getPaymentFailureDetails(PaymentFailureDto payreq) {
		// TODO Auto-generated method stub
		
		PaymentFailure paymentFailure =(PaymentFailure) AmirthumUtills.convertToDto(payreq, PaymentFailure.class, modelMapper);
		paymentFailureRepository.save(paymentFailure);
		return new GenericResponse(Constant.PAYMENT_SUCCESS);
	}

}
