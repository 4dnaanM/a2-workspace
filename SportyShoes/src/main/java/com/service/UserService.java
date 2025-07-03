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

    public void addUser(String userName, String userRole, String email, String password){
        User user = new User(userName, userRole, email, password);
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

    public boolean isAdmin(String userName, String password) {
        List<User> users = userRepository.findByUserNameAndPassword(userName, password);
        return !users.isEmpty() && "admin".equalsIgnoreCase(users.get(0).getUserRole());
    }    

    public boolean isUser(String userName, String password) {
        List<User> users = userRepository.findByUserNameAndPassword(userName, password);
        return !users.isEmpty();
    }

    public int getId(String userName, String password){
        List<User> users = userRepository.findByUserNameAndPassword(userName, password);
        return users.get(0).getUserId();
    }
    
}
