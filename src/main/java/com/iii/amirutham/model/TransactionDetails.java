/**
 * 
 */
package com.iii.amirutham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * @author admin
 *
 */
@Getter
@Setter
@Entity
@Table(name = "Paymenttransactions")
public class TransactionDetails extends BaseEntity {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer transId;
	
	@Column(name = "orderId")
	private Integer orderId;
	
		
	@Column(name = "paymentOrderReference")
	private String paymentOrderReference;
	
	
	@Column(name = "paymentTrype")
	private String transactionType;
	
	@Column(name = "paymentStatus")
	private String transactionStatus;
	
	@Column(name = "paymentErrorReason")
	private String paymentErrorReason;
	
	@Column(name = "paymentReference")
	private String paymentReference;
	
	@Column(name = "paymentRefundReference")
	private String paymentRefundReference;

	public TransactionDetails(Integer orderId, String paymentOrderReference, String transactionType,
			String transactionStatus) {
		super();
		this.orderId = orderId;
		this.paymentOrderReference = paymentOrderReference;
		this.transactionType = transactionType;
		this.transactionStatus = transactionStatus;
	
	}

	
	
	
	
	

}
