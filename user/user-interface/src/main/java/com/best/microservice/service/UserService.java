package com.best.microservice.service;

import com.best.microservice.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

//@@RestController 接口无法实例化不能加该注解
public interface UserService {

    @GetMapping("/user")
    public User getUser();
}
