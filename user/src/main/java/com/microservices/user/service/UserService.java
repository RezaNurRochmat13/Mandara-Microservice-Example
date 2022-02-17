package com.microservices.user.service;

import com.microservices.user.entity.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();
    User findUserById(Long id);
    User createUser(User payload);
    User updateUser(Long id, User payload);
    void deleteUser(Long id);
}
