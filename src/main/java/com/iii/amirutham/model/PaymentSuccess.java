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
@Table(name = "paymentsuccess")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentSuccess {
	
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	private String razorpaymentId;
	
	private String razororderRef;
	
	private String razorStatus;
	
	private String paidAmount;
	
	private String paidMethod;
	
	private String razorResponse;

}
