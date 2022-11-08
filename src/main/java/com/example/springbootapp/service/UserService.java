package com.example.springbootapp.service;

import com.example.springbootapp.model.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    void saveUser(User user);

    void deleteUser(Long id);

    User findById(Long id);

    void updateUser(User user);
}
