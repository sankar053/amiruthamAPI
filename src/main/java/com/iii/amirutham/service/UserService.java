/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.iii.amirutham.config.UserDetailsImpl;
import com.iii.amirutham.dto.model.UserDto;
import com.iii.amirutham.dto.model.ValidateOtpDto;
import com.iii.amirutham.model.order.Orders;
import com.iii.amirutham.model.user.User;

/**
 * @author sanka
 *
 */
public interface UserService {
	
	public List<User> findAllUsers();
	
	public Optional<User> findUserById(int id);
	
	public User registerNewUserAccount(UserDto userData);
	
	public void deleteUserById(int id);

	public Optional<User> findByUserName(String userEmailORPhone);
	
	public boolean updatePassword(ValidateOtpDto otpDto);

	public void addUserLocation(User registered, String clientIP);

	public void createVerificationTokenForUser(User user, String token);
	
	public UserDetailsImpl getUserDetails();

	String createPasswordResetTokenForUser(User user);

	public Page<Orders> myorders(Integer pageNo, Integer pageSize,Pageable pageable);
	
	public boolean checkIfValidOldPassword(UserDetailsImpl user,String oldPassword);
	
	public void changeUserPassword(String userName,String password);

	public void constructOTPEmail(User user, String otp);
}
