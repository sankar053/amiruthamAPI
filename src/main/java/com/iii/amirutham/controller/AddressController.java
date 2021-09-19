/**
 * 
 */
package com.iii.amirutham.controller;

import java.util.List;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.model.AddressDto;
import com.iii.amirutham.model.Address;
import com.iii.amirutham.service.AddressService;

/**
 * @author sanka
 *
 */
@RestController
@RequestMapping("/shipping/address")
public class AddressController {

	@Autowired
	private AddressService addressservice;

	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<List<Address>> getAlladdress(HttpServletRequest request) {
		List<Address> addresslist = addressservice.getAlladdress();
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(addresslist.stream().filter(a->a.getIsDeleted().equalsIgnoreCase("N"))
				.collect(Collectors.toList()));
	}
	
	@PutMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<Address> editAddress(HttpServletRequest request,@Valid @RequestBody AddressDto addressRequest) {
		Address addressDao = addressservice.updateAddressById(addressRequest);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body(addressDao);
	}
	
	@DeleteMapping("/{id}")
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<String> deleteAddress(@PathVariable Integer  id) {
		addressservice.deleteAddressById(id);
		return ResponseEntity.ok().contentType(MediaType.APPLICATION_JSON).body("Deleted Successfully");
	}

}
