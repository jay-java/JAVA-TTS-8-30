package com.rest.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import com.rest.controller.MyController;
import com.rest.model.User;
import com.rest.repository.UserRepository;

@Component
public class UserService {

    private final MyController myController;

	@Autowired
	private UserRepository repo;

    UserService(MyController myController) {
        this.myController = myController;
    }

	public List<User> fetchAllUser() {
		return this.repo.findAll();
	}

	public List<User> fetchAlllUser(Integer pageNumber, Integer pageSize) {
		Pageable p = PageRequest.of(pageNumber, pageSize);
		Page<User> pageUsers = this.repo.findAll(p);
		 List<User> list = pageUsers.getContent();
		return list;
	}

	public User addUser(User u) {
		System.out.println("in service : " + u);
		return this.repo.save(u);
	}

	public Optional<User> getUserById(long id) {
		return this.repo.findById(id);
	}

	public List<User> getUserByName(String name) {
		return this.repo.findByName(name);
	}

	public Optional<User> getUserByNameAndContact(String name, long contact) {
		return this.repo.findByNameAndContact(name, contact);
	}

	public User updateUser(User u) {
		return this.repo.save(u);
	}

	public void deleteUser(long id) {
		this.repo.deleteById(id);
	}

}
