package com.best.serviceconsumer.controller;

import com.best.microservice.entity.User;
import com.best.serviceconsumer.client.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CallUserController {

    @Autowired
    UserClient userClient;

    @GetMapping("/callUser")
    public User callUser() {
        return userClient.getUser();
    }
}
