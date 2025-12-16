package com.rest.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rest.model.User;

@RestController
public class MyController {

	@GetMapping("/")
	public String msg() {
		return "msg";
	}

	@GetMapping("/user")
	public User usersData() {
		User u = new User(1, "java", "ahmedabad", 987654321, "java@gmail.com", "java@123");
		return u;
	}
}
