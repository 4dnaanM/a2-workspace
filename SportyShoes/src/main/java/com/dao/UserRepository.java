package com.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bean.User;

public interface UserRepository extends JpaRepository<User, Integer>{
    List<User> findByUserNameContaining(String name);
    List<User> findByUserRole(String role);
    List<User> findByUserName(String name);
    List<User> findByUserNameAndPassword(String name, String password);
    List<User> findAll();
}
