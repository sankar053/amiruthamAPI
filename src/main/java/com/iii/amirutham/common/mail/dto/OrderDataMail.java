/**
 * 
 */
package com.iii.amirutham.common.mail.dto;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
public class OrderDataMail {
	
	 private String orderNo;
	 private String orderDate;
	 
	 private String name;
	 
	 private String portalUrl;
	 	 
	 private BigDecimal subtotal;
	 
	 private String shipping;
	 
	 private String codCharges;
	 
	 private String paymentMethods;
	 
	 private BigDecimal finalAmount;
	 
	 private List <OrderItemsMail> orderedItem;
	 
	 private OrderDeliveryDetails orderDeliveryDetails;

	public OrderDataMail(String orderNo,  String name, BigDecimal subtotal, String shipping,
			String codCharges, String paymentMethods, BigDecimal finalAmount, List<OrderItemsMail> orderedItem,
			OrderDeliveryDetails orderDeliveryDetails,String portalUrl) {
		super();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, YYYY");
		this.orderNo = orderNo;
		this.orderDate = simpleDateFormat.format(new Date());;
		this.name = name;
		this.subtotal = subtotal;
		this.shipping = shipping;
		this.codCharges = codCharges;
		this.paymentMethods = paymentMethods;
		this.finalAmount = finalAmount;
		this.orderedItem = orderedItem;
		this.orderDeliveryDetails = orderDeliveryDetails;
		this.portalUrl =portalUrl;
	}

//	public OrderDataMail(String name,String orderNo, List<OrderItemsMail> orderedItem,OrderDeliveryDetails orderDeliveryDetails) {
//		super();
//		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, YYYY");
//		this.orderNo = orderNo;
//		this.orderDate = simpleDateFormat.format(new Date());
//		this.orderedItem = orderedItem;
//		this.name=name;
//		this.orderDeliveryDetails =orderDeliveryDetails;
//	}
	 
	 
	 
	 
	 
	 
	 

}
