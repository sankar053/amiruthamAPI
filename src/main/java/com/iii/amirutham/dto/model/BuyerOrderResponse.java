/**
 * 
 */
package com.iii.amirutham.dto.model;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.List;

import lombok.Getter;
import lombok.Setter;

/**
 * @author admin
 *
 */
@Getter
@Setter
public class BuyerOrderResponse implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Timestamp orderDate;

	private String orderNumber;

	private String deliveryCode;
	
	private String vendorName;
	
	private String deliveryMode;

	private String trackingNumber;

	private String orderPlacedOn;
	
	private List<ProductDto> productList;
	
	private BigDecimal orderAmount;
	
	private BigDecimal additionalCharges;
	
	private BigDecimal netOrderAmount;
	
	private String line1;
	
	private String line2;
	
	private String city;
	
	private String state;
	
	private Integer zipcode;
	
	private String country;
	
	



}
