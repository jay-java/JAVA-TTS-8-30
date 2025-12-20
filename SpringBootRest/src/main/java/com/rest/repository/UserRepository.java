package com.rest.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.rest.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

	Optional<User> findByName(String name);

	Optional<User> findByNameAndContact(String name, long contact);

	User findByEmailAndPassword(String email, String password);
}
