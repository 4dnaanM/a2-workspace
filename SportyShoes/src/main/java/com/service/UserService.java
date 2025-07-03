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

    public void addUser(String userName, String userRole, String email){
        User user = new User(userName, userRole, email);
        userRepository.save(user);
    }
    
    public List<User> getUserNameContaining(String name){
        List<User> users = userRepository.findByUserNameContaining(name);
        return users; 
    }

    public List<User> getAllUsers(){
        List<User> users = userRepository.findAll();
        return users; 
    }

    public boolean isAdmin(String userName) {
        List<User> admins = userRepository.findByUserRole("admin");
        return admins.stream().anyMatch(user -> user.getUserName().equals(userName));
    }

    public boolean isUser(String userName) {
        List<User> users = userRepository.findByUserName(userName);
        return !users.isEmpty();
    }
    
}
