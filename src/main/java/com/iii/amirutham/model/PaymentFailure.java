/**
 * 
 */
package com.iii.amirutham.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author admin
 *
 */
@Entity
@Table(name = "paymentfailure")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentFailure {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String errorCode;
	
	private String errorDescription;
	
	private String errorStep;
	
	private String errorSource;
	
	private String errorReason;
	
	private String errorPaymentId;

}
