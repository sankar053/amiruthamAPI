/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Order;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.ui.freemarker.FreeMarkerTemplateUtils;

import com.google.common.base.Strings;
import com.iii.amirutham.common.EmailService;
import com.iii.amirutham.common.ReportService;
import com.iii.amirutham.common.mail.dto.OrderDataMail;
import com.iii.amirutham.common.mail.dto.OrderDeliveryDetails;
import com.iii.amirutham.common.mail.dto.OrderItemsMail;
import com.iii.amirutham.common.report.dto.InvoiceDelivaryAddressData;
import com.iii.amirutham.common.report.dto.InvoiceMerchentData;
import com.iii.amirutham.common.report.dto.OrderItemsReportData;
import com.iii.amirutham.common.report.dto.ReportInvoiceData;
import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.base.OrderStatusRequest;
import com.iii.amirutham.dto.model.AddressDto;
import com.iii.amirutham.dto.model.BuyerOrderResponse;
import com.iii.amirutham.dto.model.OrderDto;
import com.iii.amirutham.dto.model.ProductDto;
import com.iii.amirutham.dto.model.SequnceDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.Address;
import com.iii.amirutham.model.MerchantStore;
import com.iii.amirutham.model.order.OrderAttribute;
import com.iii.amirutham.model.order.OrderProduct;
import com.iii.amirutham.model.order.OrderTaxInfo;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.model.product.AmiruthamProducts;
import com.iii.amirutham.model.shoppingcart.ShoppingCart;
import com.iii.amirutham.model.shoppingcart.ShoppingCartItem;
import com.iii.amirutham.model.shoppingcart.TaxInformation;
import com.iii.amirutham.model.user.User;
import com.iii.amirutham.repo.AddressRepository;
import com.iii.amirutham.repo.CartRepository;
import com.iii.amirutham.repo.OrderRepository;
import com.iii.amirutham.repo.ProductRepository;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.service.OrderService;
import com.iii.amirutham.service.SequenceService;
import com.iii.amirutham.service.UserService;
import com.iii.amirutham.utills.AmirthumUtills;
import com.iii.amirutham.utills.Constant;
import com.iii.amirutham.utills.NotificationHelper;

import freemarker.template.Configuration;
import freemarker.template.Template;

/**
 * @author sanka
 *
 */
@Service
public class OrderServiceImpl implements OrderService {

	@Autowired
	private UserService userService;

	@Autowired
	private EmailService emailService;

	@Autowired
	private ReportService reportservice;

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private CartRepository cartRepository;

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private ProductRepository productRepository;

	@Autowired
	private AddressRepository addressRepo;

	@Autowired
	private SequenceService seqservice;

	@Value("${mail.header.image}")
	private String mailHeaderImage;

	@Autowired
	private Configuration config;

	@Value("${mail.confirmOrderEmail.template}")
	private String confirmOrderEmailTemplate;

	@Value("${mail.delivery.subject}")
	private String orderStatusDelverySubject;

	@Value("${mail.delivery.template}")
	private String orderStatusDelveryTemplate;

	@Autowired
	NotificationHelper notificationHelper;
	@Value("${domain.url}")
	private String domain;

	@Value("${mail.orderCreationEmail.template}")
	private String createOrderEmailTemplate;

	@Value("${mail.orderCreationEmail.subject}")
	private String createOrderEmailSubject;

	@Override
	public String placeOrder(OrderDto orderDto) {
		// TODO Auto-generated method stub
		UserDetailsImpl user = userService.getUserDetails();
		Optional<ShoppingCart> mycart = cartRepository.findById(orderDto.getCartId());
		if (mycart.isPresent() && "Pending".equals(mycart.get().getShoppingCartStatus())) {
			ShoppingCart mypendingCart = mycart.get();
			Orders orderDao = new Orders();
			// order.setCustomerId(user.getId());
			SequnceDto sequence = seqservice.findMySeQuence("ORDER");
			orderDao.setOrderCode(sequence.getSeqChar() + String.format("%05d", sequence.getSeqNxtVal()));
			seqservice.updateMySeQuence(sequence);
			orderDao.setLastModified(new Date());
			orderDao.setDatePurchased(new Date());
			orderDao.setReceiverName(orderDto.getReceiverName());
			orderDao.setReceiverPhoneNumber(orderDto.getReceiverPhoneNumber());
			orderDao.setGrossTotal(mypendingCart.getFinalpriceWithoutTax());
			orderDao.setNetTotal(mypendingCart.getFinalpriceWithTax());
			orderDao.setShoppingCartCode(mypendingCart.getShoppingCartCode());
			orderDao.setUser(userRepository.findById(user.getId()).get());
			orderDao.setAddress(getShippingAddress(orderDto.getShippingAddress(), orderDao.getUser()));
			orderDao.setMerchantStore(new MerchantStore());
			Set<OrderProduct> orderProducts = new LinkedHashSet<OrderProduct>();

			for (ShoppingCartItem cartItem : mypendingCart.getLineItems()) {
				Optional<AmiruthamProducts> product = productRepository.findById(cartItem.getProductId());
				if (product.isPresent()) {
					OrderProduct oProduct = new OrderProduct();

					oProduct.setOrderedproductCode(cartItem.getProductCode());
					oProduct.setOrderedproductName(product.get().getProductNm());
					oProduct.setProductPrice(cartItem.getItemPrice());
					oProduct.setSubTotal(cartItem.getSubTotal());
					oProduct.setOrderedproductId(cartItem.getProductId());
					oProduct.setOrderedQuantity(cartItem.getQuantity());
					oProduct.setProductImgURL(cartItem.getItemImgURL());
					oProduct.setAttributes(new OrderAttribute(cartItem.getAttributes().getMaximumRetailPrice(),
							cartItem.getAttributes().getSellingPrice(), cartItem.getAttributes().getSavedPrice(),
							cartItem.getAttributes().getDiscount(), cartItem.getAttributes().getUnit(),
							cartItem.getAttributes().getUnitType(), cartItem.getAttributes().getProdCode(),
							cartItem.getAttributes().getManufactureDate(), cartItem.getAttributes().getBestBeforeDate(),
							oProduct));
					TaxInformation taxinfo = cartItem.getTaxinfo();

					oProduct.setOrdertaxinfo(new OrderTaxInfo(taxinfo.getFinalTaxAmount(),
							taxinfo.getTotalTaxPresentage(), taxinfo.getSgstPresentage(), taxinfo.getSgst(),
							taxinfo.getCgstPresentage(), taxinfo.getCgst(), "Tax Deducted"));
					oProduct.setOrder(orderDao);
					orderProducts.add(oProduct);
				}
			}
			orderDao.setOrderProducts(orderProducts);

			// orderDao = orderRepository.save(orderDao);
			cartRepository.updateShoppingCartStatus(orderDto.getCartId(), "Converted");

			sendOrderCreationMail(user, orderDao, orderDao.getAddress(), LocalDateTime.now().toString());

			// sentMailforOrderConformation(orderDao, user,"order-Conformation-template");

			return orderDao.getOrderCode();
		}
		return null;

	}

	void sentMailforOrderConformation(Orders orderDao, UserDetailsImpl user, String template) {

		List<OrderItemsMail> orderedItem = new ArrayList<OrderItemsMail>();

		Set<OrderProduct> orderedProducts = orderDao.getOrderProducts();
		if (null != orderedProducts) {
			for (OrderProduct product : orderedProducts) {
				orderedItem.add(new OrderItemsMail(product.getOrderedproductName(), product.getOrderedQuantity(),
						product.getProductPrice(),
						"https://raw.githubusercontent.com/sankar053/amiruthumimg/main/Products/Oils/"
								+ product.getOrderedproductCode() + ".jpg"));
			}
		}

		Address shippingAddress = orderDao.getAddress();
		OrderDeliveryDetails address = new OrderDeliveryDetails(orderDao.getReceiverName(), user.getEmail(),
				orderDao.getReceiverPhoneNumber(), shippingAddress.getAddress1() + " " + shippingAddress.getAddress2(),
				shippingAddress.getCity() + "-" + shippingAddress.getPostalCopde(), shippingAddress.getState());

		OrderDataMail order = new OrderDataMail(orderDao.getOrderCode(), user.getFirstName(), orderDao.getGrossTotal(),
				"Free Shipping", "50", "COD", orderDao.getNetTotal(), orderedItem, address, "http:localhost:4200/home",
				orderDao.getOrderStatus().getValue(), orderDao.getOrderTrackingUrl());
		emailService.sendTemplateEmail(user.getEmail(), "Order #" + orderDao.getOrderCode() + " Confirmed!", template,
				order, null);
	}

	void sentMailforOrderstatus(Orders orderDao, User user, String template) {

		List<OrderItemsMail> orderedItem = new ArrayList<OrderItemsMail>();

		Set<OrderProduct> orderedProducts = orderDao.getOrderProducts();
		if (null != orderedProducts) {
			for (OrderProduct product : orderedProducts) {
				orderedItem.add(new OrderItemsMail(product.getOrderedproductName(), product.getOrderedQuantity(),
						product.getProductPrice(), ""));
			}
		}

		Address shippingAddress = orderDao.getAddress();
		OrderDeliveryDetails address = new OrderDeliveryDetails(orderDao.getReceiverName(), user.getEmailAddress(),
				orderDao.getReceiverPhoneNumber(), shippingAddress.getAddress1() + " " + shippingAddress.getAddress2(),
				shippingAddress.getCity() + "-" + shippingAddress.getPostalCopde(), shippingAddress.getState());

		OrderDataMail order = new OrderDataMail(orderDao.getOrderCode(), user.getFirstName(), orderDao.getGrossTotal(),
				"Free Shipping", "50", "COD", orderDao.getNetTotal(), orderedItem, address, "http:localhost:4200/home",
				orderDao.getOrderStatus().getValue(), orderDao.getOrderTrackingUrl());
		emailService.sendTemplateEmail(user.getEmailAddress(), "Your Amiruthum ePortal order has been received!",
				template, order, null);
	}

	public Address getShippingAddress(AddressDto addressDto, User u) {
		if (null != addressDto.getId()) {
			Optional<Address> address = addressRepo.findById(addressDto.getId());
			if (address.isPresent())
				return address.get();
			else
				return addressRepo.save(new Address(addressDto.getAddress1(), addressDto.getAddress2(), "Shipment",
						addressDto.getCity(), addressDto.getState(), addressDto.getPostalCopde(), u));
		} else {
			return addressRepo.save(new Address(addressDto.getAddress1(), addressDto.getAddress2(), "Shipment",
					addressDto.getCity(), addressDto.getState(), addressDto.getPostalCopde(), u));
		}

	}

	@Override
	public Orders getOrdersById(Integer id) {
		// TODO Auto-generated method stub
		Optional<Orders> order = orderRepository.findById(id);
		if (order.isPresent())
			return order.get();
		else
			throw new UserNotFoundException("Orders Not Found");
	}

	@Override
	public Page<Orders> getAllOrders(Integer pageNo, Integer pageSize, Pageable pageable) {
		// TODO Auto-generated method stub
		if (pageNo != null && pageSize != null)
			pageable = PageRequest.of(pageNo, pageSize, Sort.by(Order.desc("createdTs"), Order.desc("id")));
		return orderRepository.findAll(pageable);

	}

	@Override
	public void updateOrderprocess(OrderStatusRequest orderStatusReq) {
		// TODO Auto-generated method stub
		Optional<Orders> oorder = orderRepository.findById(orderStatusReq.getOrderId());
		if (oorder.isPresent()) {

			if ("PROCESSED".equalsIgnoreCase(orderStatusReq.getOrderStatus().getValue())) {
				orderRepository.updateOrderStatus(orderStatusReq.getOrderId(), orderStatusReq.getOrderStatus(),
						orderStatusReq.getTrackingUrl());
				sendOrderDelivaryMail(oorder.get().getUser(), oorder.get(), oorder.get().getAddress(),
						orderStatusReq.getTrackingUrl());
			} else {
				orderRepository.updateOrderStatus(orderStatusReq.getOrderId(), orderStatusReq.getOrderStatus());
				sentMailforOrderstatus(oorder.get(), oorder.get().getUser(), "order-Status-Update-template");
			}
		} else {
			throw new UserNotFoundException("Selected orger is invalid");
		}

	}

	public ReportInvoiceData generateInvoice(Orders orderDao) {

		List<OrderItemsReportData> orderedItem = new ArrayList<OrderItemsReportData>();

		Set<OrderProduct> orderedProducts = orderDao.getOrderProducts();
		if (null != orderedProducts) {
			for (OrderProduct product : orderedProducts) {

				orderedItem.add(new OrderItemsReportData(product.getOrderedproductName(), product.getOrderedQuantity(),
						product.getSubTotal(), product.getSubTotal().add(product.getOrdertaxinfo().getFinalTaxAmount()),
						product.getOrdertaxinfo().getFinalTaxAmount()));
			}
		}

		Address shippingAddress = orderDao.getAddress();
		InvoiceDelivaryAddressData shippingAddressdata = new InvoiceDelivaryAddressData(orderDao.getReceiverName(),
				shippingAddress.getAddress1(), shippingAddress.getAddress2(), shippingAddress.getCity(),
				shippingAddress.getState(), shippingAddress.getPostalCopde());
		ReportInvoiceData invoiceData = new ReportInvoiceData(orderDao.getOrderCode(), orderDao.getReceiverName(),
				"Free Shipping", "50", "COD", orderDao.getGrossTotal(), orderDao.getNetTotal(),
				orderDao.getNetTotal().subtract(orderDao.getGrossTotal()), orderedItem, shippingAddressdata,
				new InvoiceMerchentData(), "http:localhost:4200/home");
		return invoiceData;

	}

	@Override
	public File getOrderInvoice(Orders reportData) {

		// TODO Auto-generated method stub

		try {
			return reportservice.getpdfTemplate("invoice-template", generateInvoice(reportData), "output.pdf");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Async("specificTaskExecutor")
	public void sendOrderCreationMail(UserDetailsImpl user, Orders order, Address shippingAddress,
			String convertedTime) {
		try {
			List<BuyerOrderResponse> buyerOrder = new ArrayList<>();
			List<ProductDto> orderItemList = null;
			BigDecimal totalAmount = new BigDecimal(0);
			BuyerOrderResponse orderMail = new BuyerOrderResponse();
			orderItemList = new ArrayList<>();
			if (!AmirthumUtills.IsNullOrEmpty(order.getOrderProducts())) {
				for (OrderProduct orderItem : order.getOrderProducts()) {
					if (orderItem != null) {
						ProductDto product = new ProductDto();
						product.setProductNm(orderItem.getOrderedproductName());
						product.setPrice(
								orderItem.getProductPrice().multiply(new BigDecimal(orderItem.getOrderedQuantity())));
						product.setDeliveryMode("Shipment");
						product.setOrderQuantity(orderItem.getOrderedQuantity());
						totalAmount = totalAmount.add(orderItem.getProductPrice());
//							product.setProductDesc(orderItem.getProduct().getProductDesc());
//							if(Strings.isNullOrEmpty(orderItem.getProduct().getProductDesc())) {
//								product.setProductDesc("Good");
//							}
						orderItemList.add(product);
					}
				}
				orderMail.setOrderNumber(order.getOrderCode());
				orderMail.setOrderAmount(order.getGrossTotal());
				orderMail.setTrackingNumber("143243242423");
				orderMail.setOrderPlacedOn(
						AmirthumUtills.getDay() + ", " + AmirthumUtills.timeStampFormat(order.getDatePurchased()));
				orderMail.setProductList(orderItemList);
			}
			buyerOrder.add(orderMail);

			Map<String, Object> mailMap = new HashMap<>();
			Map<String, Object> notificationMap = new HashMap<>();
			mailMap.put("buyerOrder", buyerOrder);
			mailMap.put("name", user.getFirstName() + " " + user.getLastName());
			mailMap.put("line1", shippingAddress.getAddress1());
			if (Strings.isNullOrEmpty(shippingAddress.getAddress2()))
				mailMap.put("line2", "");
			else
				mailMap.put("line2", shippingAddress.getAddress2());
			mailMap.put("city", shippingAddress.getCity());
			mailMap.put("state", shippingAddress.getState());
			mailMap.put("zipcode", shippingAddress.getPostalCopde());
			mailMap.put("country", "India");
			mailMap.put("amiruthamInfo", Constant.AMIRUTHAM_INFO);
			mailMap.put("loginurl", domain);
			Template mailTemplate = config.getTemplate(createOrderEmailTemplate);
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, mailMap);
			// Call Mail Service
			notificationMap.put("userMail", user.getEmail());
			notificationMap.put("subject", createOrderEmailSubject);
			notificationMap.put("html", html);
			boolean isMailSent = notificationHelper.sendNotification(Constant.NOTIFICATION_MAIL_TYPE, notificationMap);
			if (!isMailSent) {
//			throw new BusinessException(Constant.RESPONSE_FAIL, Constant.SERVER_ERROR, Constant.RESPONSE_EMPTY_DATA,
//					500);
				System.out.println("Mail Sending Failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

	@Async("specificTaskExecutor")
	public void sendOrderDelivaryMail(User user, Orders order, Address shippingAddress, String trackingid) {
		try {
			List<BuyerOrderResponse> buyerOrder = new ArrayList<>();
			List<ProductDto> orderItemList = null;
			BigDecimal totalAmount = new BigDecimal(0);
			BuyerOrderResponse orderMail = new BuyerOrderResponse();
			orderItemList = new ArrayList<>();
			if (!AmirthumUtills.IsNullOrEmpty(order.getOrderProducts())) {
				for (OrderProduct orderItem : order.getOrderProducts()) {
					if (orderItem != null) {
						ProductDto product = new ProductDto();
						product.setProductNm(orderItem.getOrderedproductName());
						product.setPrice(
								orderItem.getProductPrice().multiply(new BigDecimal(orderItem.getOrderedQuantity())));
						product.setDeliveryMode("Shipment");
						product.setOrderQuantity(orderItem.getOrderedQuantity());
						totalAmount = totalAmount.add(orderItem.getProductPrice());
//							product.setProductDesc(orderItem.getProduct().getProductDesc());
//							if(Strings.isNullOrEmpty(orderItem.getProduct().getProductDesc())) {
//								product.setProductDesc("Good");
//							}
						orderItemList.add(product);
					}
				}
				orderMail.setOrderNumber(order.getOrderCode());
				orderMail.setOrderAmount(order.getGrossTotal());
				orderMail.setTrackingNumber(trackingid);
				orderMail.setOrderPlacedOn(
						AmirthumUtills.getDay() + ", " + AmirthumUtills.timeStampFormat(order.getDatePurchased()));
				orderMail.setProductList(orderItemList);
			}
			buyerOrder.add(orderMail);

			Map<String, Object> mailMap = new HashMap<>();
			Map<String, Object> notificationMap = new HashMap<>();
			mailMap.put("buyerOrder", buyerOrder);
			mailMap.put("name", user.getFirstName() + " " + user.getLastName());
			mailMap.put("line1", shippingAddress.getAddress1());
			if (Strings.isNullOrEmpty(shippingAddress.getAddress2()))
				mailMap.put("line2", "");
			else
				mailMap.put("line2", shippingAddress.getAddress2());
			mailMap.put("city", shippingAddress.getCity());
			mailMap.put("state", shippingAddress.getState());
			mailMap.put("zipcode", shippingAddress.getPostalCopde());
			mailMap.put("country", "India");
			mailMap.put("amiruthamInfo", Constant.AMIRUTHAM_INFO);
			mailMap.put("loginurl", domain);
			Template mailTemplate = config.getTemplate(orderStatusDelveryTemplate);
			String html = FreeMarkerTemplateUtils.processTemplateIntoString(mailTemplate, mailMap);
			// Call Mail Service
			notificationMap.put("userMail", user.getEmailAddress());
			notificationMap.put("subject", orderStatusDelverySubject);
			notificationMap.put("html", html);
			boolean isMailSent = notificationHelper.sendNotification(Constant.NOTIFICATION_MAIL_TYPE, notificationMap);
			if (!isMailSent) {
//			throw new BusinessException(Constant.RESPONSE_FAIL, Constant.SERVER_ERROR, Constant.RESPONSE_EMPTY_DATA,
//					500);
				System.out.println("Mail Sending Failed");
			}

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		}

	}

}