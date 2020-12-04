package com.iii.amirutham.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.iii.amirutham.dto.model.UserDto;
import com.iii.amirutham.model.User;
import com.iii.amirutham.service.UserService;

@RestController
@RequestMapping
public class UserController {

	@Autowired
	private UserService userDaoService;

	@GetMapping("/users")
	public List<User> retriveAllUsers() {
		return userDaoService.findAllUsers();

	}

	@GetMapping("/users/{id}")
	public User retriveUsersById(@PathVariable int id) {
		Optional<User> user = userDaoService.findUserById(id);
		return (user.get());

	}

	@PostMapping("/sign-up")
	public ResponseEntity<Object> createUser(@Valid @RequestBody UserDto user) {
		System.out.println();
		User savedUser = userDaoService.createUser(user);

		return new ResponseEntity<Object>(savedUser, HttpStatus.OK);
	}

	@DeleteMapping("/users/{id}")
	public ResponseEntity<Object> deleteUser(@PathVariable int id) {

		userDaoService.deleteUserById(id);
		return new ResponseEntity<>("User got Deleted Succesfully", HttpStatus.OK);

	}

}
