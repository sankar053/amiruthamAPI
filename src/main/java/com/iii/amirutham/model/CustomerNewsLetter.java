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

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Entity(name = "contactus")
@Table(name = "contactus")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class CustomerNewsLetter {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;
	
	@Column(name = "emailAddress",nullable = false)
	private String emailAddress;
	
	@Column(name = "phoneNumber",nullable = true)
	private String phoneNbr;
	
	
	@Column(name = "firstName",nullable = true)
	private String firstName;

	@Column(name = "lastName",nullable = true)
	private String lastName;

	public CustomerNewsLetter(String emailAddress, String firstName) {
		super();
		this.emailAddress = emailAddress;
		this.firstName = firstName;
	}
	
	
	
	

}
