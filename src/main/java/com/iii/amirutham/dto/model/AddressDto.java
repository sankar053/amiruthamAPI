/**
 * 
 */
package com.iii.amirutham.dto.model;

import com.sun.istack.NotNull;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author sanka
 *
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AddressDto {

	private Integer id;

	@NotNull
	private String address1;

	private String address2;

	private String addressType;

	@NotNull
	private String city;
	
	@NotNull
	private String state;

	@NotNull
	private String postalCopde;
	
	

}
