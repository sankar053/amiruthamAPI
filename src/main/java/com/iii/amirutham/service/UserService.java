/**
 * 
 */
package com.iii.amirutham.service;

import java.util.List;

import com.iii.amirutham.model.User;

/**
 * @author sanka
 *
 */
public interface UserService {
	
	public List<User> findAllUsers();
	
	public User findUserById(int i);
	
	public User createUser(User userData);
	
	public User deleteUserById(int id);
}
