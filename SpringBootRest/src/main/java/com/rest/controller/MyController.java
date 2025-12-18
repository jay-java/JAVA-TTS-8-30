package com.rest.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.User;
import com.rest.repository.UserRepository;
import com.rest.service.UserService;

@RestController
public class MyController {

	@Autowired
	private UserService service;

	@GetMapping("/")
	public String msg() {
		return "msg";
	}

//	@GetMapping("/user")
//	public List<User> usersData() {
//		List<User> list = Arrays.asList(new User(1, "java", "ahmedabad", 98765321, "java@gmail.com", "j@123"),
//				new User(2, "python", "delhi", 98765321, "python@gmail.com", "p@123"),
//				new User(3, "dart", "mumbai", 98765321, "dart@gmail.com", "d@123"));
//		return list;
//	}

	@GetMapping("/users")
	public List<User> getAllUsers() {
		return this.service.fetchAllUser();
	}

	@PostMapping("/user")
	public User addNewUser(@RequestBody User u) {
		return this.service.addUser(u);
	}
}
