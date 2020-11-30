/**
 * 
 */
package com.iii.amirutham.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iii.amirutham.model.User;
import com.iii.amirutham.repo.UserRepository;
import com.iii.amirutham.service.UserService;

/**
 * @author sanka
 *
 */
@Service
public class UserServiceImpl implements UserService {
	
	
	  @Autowired 
	  private UserRepository userRepo;
	 
	@Override
	public List<User> findAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User findUserById(int i) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public User createUser(User userData) {
		
		// TODO Auto-generated method stub
	return userRepo.save(userData);
	}

	@Override
	public User deleteUserById(int id) {
		return null;
		// TODO Auto-generated method stub

	}

}
