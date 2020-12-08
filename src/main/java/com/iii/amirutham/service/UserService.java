/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;
import java.util.Optional;

import com.iii.amirutham.dto.model.UserDto;
import com.iii.amirutham.dto.model.ValidateOtpDto;
import com.iii.amirutham.model.User;

/**
 * @author sanka
 *
 */
public interface UserService {
	
	public List<User> findAllUsers();
	
	public Optional<User> findUserById(int id);
	
	public User registerNewUserAccount(UserDto userData);
	
	public void deleteUserById(int id);

	public Optional<User> findUserByEmail(String userEmailORPhone);
	
	public boolean updatePassword(ValidateOtpDto otpDto);

	public void addUserLocation(User registered, String clientIP);

	public void createVerificationTokenForUser(User user, String token);

	String createPasswordResetTokenForUser(User user, String token);
}
