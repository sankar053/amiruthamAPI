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

@Entity(name = "address")
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer id;

	@Column(name = "addressLine1")
	private String address1;

	@Column(name = "addressLine2")
	private String address2;

	@Column(name = "addressType")
	private String addressType;

	@Column(name = "city")
	private String city;

	@Column(name = "state")
	private String state;

	@Column(name = "postalCopde")
	private String postalCopde;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY)
	 * 
	 * @JoinColumn(name = "userId", nullable = false) private User user;
	 */

	public Address(String address1, String address2, String addressType, String city, String state,
			String postalCopde) {
		super();
		this.address1 = address1;
		this.address2 = address2;
		this.addressType = addressType;
		this.city = city;
		this.state = state;
		this.postalCopde = postalCopde;
	}
	
	

}
