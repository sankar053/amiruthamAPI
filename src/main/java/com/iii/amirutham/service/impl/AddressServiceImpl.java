/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.model.AddressDto;
import com.iii.amirutham.exception.UserNotFoundException;
import com.iii.amirutham.model.Address;
import com.iii.amirutham.model.user.User;
import com.iii.amirutham.repo.AddressRepository;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.service.AddressService;
import com.iii.amirutham.service.UserService;

/**
 * @author sanka
 *
 */
@Service
public class AddressServiceImpl implements AddressService{

	@Autowired
	private AddressRepository addressRepo;
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private UserService userService;
	
	@Override
	public List<Address> getAlladdress() {
		// TODO Auto-generated method stub
		UserDetailsImpl user = userService.getUserDetails();
		User customer= userRepository.findById(user.getId()).get();
		return addressRepo.findByUser(customer);
	}

	@Override
	public Address updateAddressById(@Valid AddressDto addressRequest) {
		// TODO Auto-generated method stub
		Optional<Address> address = addressRepo.findById(addressRequest.getId());
		if(address.isPresent()) {
			Address addressDao = address.get();
			addressDao.setAddress1(addressRequest.getAddress1());
			addressDao.setAddress2(addressRequest.getAddress2());
			addressDao.setAddressType(addressRequest.getAddressType());
			addressDao.setCity(addressRequest.getCity());
			addressDao.setState(addressRequest.getState());
			addressDao.setPostalCopde(addressRequest.getPostalCopde());
			
			return addressRepo.save(addressDao);
		}else {
			throw new UserNotFoundException("Selected Address not found");
		}
		
	}

}
