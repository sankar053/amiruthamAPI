/**
 * 
 */
package com.iii.amirutham.dto.model;

import javax.validation.Valid;

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
public class OrderDto {

	@NotNull
	private Integer cartId;
	
	@NotNull
	private String receiverName;
	
	@NotNull
	private String receiverPhoneNumber;

	@Valid
	private AddressDto shippingAddress;

}
