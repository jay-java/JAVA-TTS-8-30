package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.repository.UserRepository;

@Component
public class UserService {

	@Autowired
	private UserRepository repo;

	public List<User> fetchAllUser() {
		return this.repo.findAll();
	}

	public User addUser(User u) {
		System.out.println("in service : " + u);
		return this.repo.save(u);
	}

	public Optional<User> getUserById(long id) {
		return this.repo.findById(id);
	}

	public Optional<User> getUserByName(String name) {
		return this.repo.findByName(name);
	}

	public Optional<User> getUserByNameAndContact(String name, long contact) {
		return this.repo.findByNameAndContact(name, contact);
	}

	public User updateUser(User u) {
		return this.repo.save(u);
	}
	
	
}
