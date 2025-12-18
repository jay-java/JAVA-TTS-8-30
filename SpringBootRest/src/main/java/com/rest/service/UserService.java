package com.rest.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.rest.model.User;
import com.rest.repository.UserRepository;

@Service
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
}
