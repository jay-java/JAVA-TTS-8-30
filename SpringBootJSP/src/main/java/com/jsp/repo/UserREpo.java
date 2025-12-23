package com.jsp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.jsp.model.User;

public interface UserREpo extends JpaRepository<User, Integer>{

}
