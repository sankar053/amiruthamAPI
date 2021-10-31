package com.iii.amirutham.controller.payment;

import java.time.LocalDateTime;
import java.util.Optional;

import org.json.JSONArray;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.iii.amirutham.dto.model.PaymentSuccesDto;
import com.iii.amirutham.model.PaymentSuccess;
import com.iii.amirutham.model.TransactionDetails;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.repo.OrderRepository;
import com.iii.amirutham.repo.PaymentSuccessRepo;
import com.iii.amirutham.repo.TransactionDetailsRepo;
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

	@Override
	public Order createOrderWothRazorPay(PaymentRequest payreq) {

		try {

			JSONObject options = new JSONObject();
			// options.put("amount", payreq.getAmount().multiply(new BigDecimal("10000")));
			// // Note: The amount should be in paise.
			options.put("amount", 100);
			options.put("currency", payreq.getCurrency());
			options.put("receipt", payreq.getAmirthumorderRef());
			Order order = razorpayClient.Orders.create(options);

			TransactionDetails transaction = new TransactionDetails(payreq.getAmirthumorderId(), order.get("id"),
					"ORDER", "S");
			transactionRepo.save(transaction);

			return order;
			// System.out.println(order.toString());

		} catch (RazorpayException e) {
			// TODO Auto-generated catch bltransactionock
			e.printStackTrace();
			TransactionDetails transaction = new TransactionDetails(payreq.getAmirthumorderId(), "", "ORDER", "F");
			transaction.setPaymentErrorReason(e.getMessage());
			transactionRepo.save(transaction);
		} catch (Exception e) {
			e.printStackTrace();
			TransactionDetails transaction = new TransactionDetails(payreq.getAmirthumorderId(), "", "ORDER", "F");
			transaction.setPaymentErrorReason(e.getMessage());
			transactionRepo.save(transaction);
		}
		// TODO Auto-generated method stub
		return null;

	}

	@Override
	public void createInvoice(PaymentRequest payreq) {
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

	}

	@Override
	public void capturePayment(PaymentRequest payreq) {
		// TODO Auto-generated method stub

		try {

			JSONObject options = new JSONObject();
			options.put("amount", payreq.getAmount());
			options.put("currency", "INR");
			razorpayClient.Payments.capture("payment_id", options);
		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void getPaymentSuccessDetails(PaymentSuccesDto payreq) {
		// TODO Auto-generated method stub

		Optional<Orders> orderdao = orderRepo.findByRazorPayOrderReference(payreq.getRazorPayOrderId());
		try {

			Payment payment = razorpayClient.Payments.fetch(payreq.getRazorPayPaymentId());
			if (Boolean.valueOf(payment.get("captured").toString()) && orderdao.isPresent()) {

				Orders order = orderdao.get();
				orderRepo.updateOrderPaymentStatus(payment.get("id"), LocalDateTime.now(), payreq.getRazorPayOrderId(),
						order.getId());
				PaymentSuccess success = new PaymentSuccess();
				success.setPaidAmount(payment.get("amount").toString());
				success.setPaidMethod(payment.get("method"));
				success.setRazororderRef(payment.get("order_id"));
				success.setRazorpaymentId(payment.get("id"));
				success.setRazorResponse(payment.toString());
				success.setRazorStatus(payment.get("status"));
				raymentSuccessRepo.save(success);

			}

		} catch (RazorpayException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Override
	public void initiaterefund(String paymentId) {
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

				}

			} catch (RazorpayException e) {
				// TODO Auto-generated catch block
				TransactionDetails transaction = new TransactionDetails(order.getId(),
						order.getRazorPayOrderReference(), "REFUND", "F");
				transaction.setPaymentErrorReason(e.getMessage());
				transactionRepo.save(transaction);
			} catch (Exception e) {
				e.printStackTrace();
				TransactionDetails transaction = new TransactionDetails(order.getId(), "", "REFUND", "F");
				transaction.setPaymentErrorReason(e.getMessage());
				transactionRepo.save(transaction);
			}

		}

	}

}
