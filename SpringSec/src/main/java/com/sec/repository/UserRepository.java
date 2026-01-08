package com.sec.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import com.sec.model.User;

import java.util.Optional;

public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByUsername(String username);
}