package com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bean.User; 
import com.dao.UserRepository;

@Service
public class UserService {
    
    @Autowired
    UserRepository userRepository;

    void addUser(User user){
        userRepository.save(user);
    }
    
    List<User> getUserNameContaining(String name){
        List<User> users = userRepository.findByUserNameContaining(name);
        return users; 
    }

    List<User> getAllUsers(String name){
        List<User> users = userRepository.findAll();
        return users; 
    }
}
