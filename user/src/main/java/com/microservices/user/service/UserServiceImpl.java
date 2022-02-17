package com.microservices.user.service;

import com.microservices.user.entity.User;
import com.microservices.user.repository.UserRepository;
import com.microservices.user.util.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> findAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User findUserById(Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id : " + id));
    }

    @Override
    public User createUser(User payload) {
        return userRepository.save(payload);
    }

    @Override
    public User updateUser(Long id, User payload) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id : " + id));

        userById.setName(payload.getName());
        userById.setAddress(payload.getAddress());
        userById.setAge(payload.getAge());

        userRepository.save(userById);

        return userById;
    }

    @Override
    public void deleteUser(Long id) {
        User userById = userRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Data not found with id : " + id));

        userRepository.delete(userById);
    }
}
