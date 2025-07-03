package com.bean;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int userId;
    
    @Column(unique = true)
    private String userName;
    
    private String userRole;
    private String password; 

    public User() {}

    public User(String userName, String userRole, String email, String password) {
        super();
        this.userName = userName;
        this.userRole = userRole;
        this.password = password; 
    }

    public int getUserId() {
        return userId;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserRole() {
        return userRole;
    }

    public String getPassword() {
        return password;
    }

    protected void setUserName(String userName) {
        this.userName = userName;
    }

    public void setUserRole(String userRole) {
        this.userRole = userRole;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User [userId=" + userId + ", userName=" + userName + ", userRole=" + userRole + ", password = " + password + "]";
    }
}
