package com.iii.amirutham.model;

import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity(name = "Address")
@Data
public class UserAddress extends BaseEntity {

	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private UUID id;

	//@Column(name = "USER_ADDR_LINE1")
	private String address1;

	//@Column(name = "USER_ADDR_LINE2")
	private String address2;
	
	
	@Column(name = "USER_ADDR_CITY")
	private String city;

	@Column(name = "USER_ADDR_STATE")
	private String state;
	
	//@Column(name = "USER_ADDR_ZIP")
	private String postalCopde;

}
