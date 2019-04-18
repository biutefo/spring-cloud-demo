package com.best.serviceconsumer.client;

import com.best.microservice.entity.HelloMsg;
import com.best.serviceconsumer.controller.CallHelloController;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(CallHelloController.serviceId)
public interface HelloClient {

	@GetMapping("sayHello")
	HelloMsg sayHello();
}
