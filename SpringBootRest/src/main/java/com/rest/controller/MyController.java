package com.rest.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
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
		return "application is running";
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

	@GetMapping("/pageusers")
	public List<User> getAlllUsers(
			@RequestParam(value = "pageNumber", defaultValue = "0", required = false) Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "5", required = false) Integer pageSize) {
		return this.service.fetchAlllUser(pageNumber, pageSize);
	}

	@PostMapping("/user")
	public User addNewUser(@RequestBody User u) {
		return this.service.addUser(u);
	}

	@GetMapping("/user/{id}")
	public Optional<User> getUserByID(@PathVariable("id") long id) {
		return this.service.getUserById(id);
	}

	@GetMapping("/user")
	public List<User> getUserByN(@RequestParam("name") String name) {
		System.out.println(name);
		return this.service.getUserByName(name);
	}

	@GetMapping("/userbynac")
	public Optional<User> getUserByNAndC(@RequestParam("name") String name, @RequestParam("contact") long contact) {
		return this.service.getUserByNameAndContact(name, contact);
	}

	@PutMapping("/user")
	public User updateUser(@RequestBody User u) {
		return this.service.updateUser(u);
	}

	@DeleteMapping("/user/{id}")
	public void deleteUser(@PathVariable("id") long id) {
		this.service.deleteUser(id);
	}

}
