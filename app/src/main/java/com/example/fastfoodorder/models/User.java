package com.example.fastfoodorder.models;

import java.util.UUID;

public class User {
    private String userID;
    private String name;
    private String address;
    private String phone;
    private String email;
    private String password;
    private Role role;
    private int isDelete;

    public User() {
    }

    public User(String name, String address, String phone, String email, String password, Role role) {
        this.userID = UUID.randomUUID().toString();
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
        this.isDelete = 0;
    }

    public User(String userID, String name, String address, String phone, String email, String password, Role role) {
        this.userID = userID;
        this.name = name;
        this.address = address;
        this.phone = phone;
        this.email = email;
        this.password = password;
        this.role = role;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public String getUserID() {
        return userID;
    }

    public void setUserID(String userID) {
        this.userID = userID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
