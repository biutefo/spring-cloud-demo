package com.best.microservice.service.impl;

import com.best.microservice.entity.User;
import com.best.microservice.service.UserService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserServiceImpl implements UserService {
    @Override
    @GetMapping
    public User getUser() {
        User user = new User();
        user.setUsername("admin");
        user.setPassword("12345");
        return user;
    }
}
