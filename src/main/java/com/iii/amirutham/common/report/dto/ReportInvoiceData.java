/**
 * 
 */
package com.iii.amirutham.common.report.dto;

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
public class ReportInvoiceData {
	
	
	 private String orderNo;
	 private String orderDate;
	 
	 private String name;
	 
	 private String portalUrl;
	 	 
	 private BigDecimal gstAmount;
	 
	 private String shipping;
	 
	 private String codCharges;
	 
	 private String paymentMethods;
	 
	 private BigDecimal finalAmountwithGst;
	 
	 private BigDecimal finalAmountwithoutGst;
	 
	 private List <OrderItemsReportData> orderedItem;
	 
	 private InvoiceMerchentData merchantDetails;
	 
	 private InvoiceDelivaryAddressData orderDeliveryDetails;

	public ReportInvoiceData(String orderNo,  String name,  String shipping,
			String codCharges, String paymentMethods, BigDecimal finalAmountwithoutGst, BigDecimal finalAmountwithGst,
			BigDecimal gstAmount,List<OrderItemsReportData> orderedItem,
			InvoiceDelivaryAddressData orderDeliveryDetails,InvoiceMerchentData merchantDetails,
			String portalUrl) {
		super();
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("MMM dd, YYYY");
		this.orderNo = orderNo;
		this.orderDate = simpleDateFormat.format(new Date());;
		this.name = name;
		this.gstAmount = gstAmount;
		this.shipping = shipping;
		this.codCharges = codCharges;
		this.paymentMethods = paymentMethods;
		this.finalAmountwithoutGst = finalAmountwithoutGst;
		this.finalAmountwithGst =finalAmountwithGst;
		this.orderedItem = orderedItem;
		this.orderDeliveryDetails = orderDeliveryDetails;
		this.portalUrl =portalUrl;
		this.merchantDetails=merchantDetails;
	}

}
