package com.iii.amirutham.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity(name = "userAddress")
@Table(name = "AMIR_USER_ADDR")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddress extends BaseEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "AMIR_USER_ADDR_LNE1")
	private String address1;

	@Column(name = "AMIR_USER_ADDR_LNE2")
	private String address2;
	
	@Column(name = "AMIR_USER_ADDR_TYPE")
	private String addressType;
	
	@Column(name = "AMIR_USER_ADDR_CITY")
	private String city;

	@Column(name = "AMIR_USER_ADDR_STATE")
	private String state;
	
	@Column(name = "AMIR_USER_ADDR_ZIPCODE")
	private String postalCopde;

}
