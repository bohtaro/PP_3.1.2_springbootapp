package com.example.springbootapp.service;

import com.example.springbootapp.model.User;

import java.util.List;

public interface UserService {
    public List<User> getAllUsers();

    public void saveUser(User user);

    public void removeUser(Long id);

    public User findById(Long id);

    public void updateUser(User user);
}
