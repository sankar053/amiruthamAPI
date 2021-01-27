/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;

import javax.validation.Valid;

import com.iii.amirutham.dto.model.AddressDto;
import com.iii.amirutham.model.Address;

/**
 * @author sanka
 *
 */
public interface AddressService {
	
	public List<Address> getAlladdress();

	public Address updateAddressById(@Valid AddressDto addressRequest);

}
