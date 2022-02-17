package com.microservices.user.presenter;

import com.microservices.user.entity.User;
import com.microservices.user.service.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class UserPresenter {
    @Autowired
    private UserServiceImpl userService;

    @GetMapping("/users")
    public List<User> getAllUsers() {
        return userService.findAllUsers();
    }

    @GetMapping("/users/{id}")
    public User getSingleUser(@PathVariable Long id) {
        return userService.findUserById(id);
    }

    @PostMapping("/users")
    public User createNewUser(@RequestBody User payload) {
        return userService.createUser(payload);
    }

    @PutMapping("/users/{id}")
    public User updateUser(@PathVariable Long id, @RequestBody User payload) {
        return userService.updateUser(id, payload);
    }

    @DeleteMapping("/users/{id}")
    public void deleteUser(@PathVariable Long id) {
        userService.deleteUser(id);
    }

}
