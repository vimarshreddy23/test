package com.loan.management.loginservice.dao;


import org.springframework.data.jpa.repository.JpaRepository;

import com.loan.management.loginservice.model.User;

public interface UserDao extends JpaRepository<User, Integer> {

    User findByUsername(String username);

    User findByEmail(String email);
}
