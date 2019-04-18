package com.best.serviceconsumer.client;

import com.best.microservice.service.UserService;
import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("user-service")
public interface UserClient extends UserService {
}
