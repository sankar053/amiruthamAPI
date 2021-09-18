/**
 * 
 */
package com.iii.amirutham.dto.base;

import java.time.LocalDateTime;

import javax.validation.constraints.NotBlank;

import com.iii.amirutham.model.order.OrderStatus;
import com.iii.amirutham.model.order.PaymentType;
import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author admin
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class OrderStatusRequest {
	
	@NotNull
	private OrderStatus orderStatus;
	
	private String trackingUrl;
	
	@NotNull
	private Integer orderId;
	
	@NotNull
	private PaymentType paymentType;
	
	private String transactionRefNo;
	
	private LocalDateTime paymentOn;


}
