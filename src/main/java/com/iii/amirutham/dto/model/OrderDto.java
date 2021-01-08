/**
 * 
 */
package com.iii.amirutham.dto.model;

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

	private Integer cartId;

	private AddressDto shippingAddress;

}
