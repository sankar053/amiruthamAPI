package com.iii.amirutham.dto.model;

import com.iii.amirutham.model.BaseEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserAddressDto extends BaseEntity {

	private String address1;

	private String address2;
	
	private String addressType;

	private String city;

	private String state;

	private String postalCopde;

}
