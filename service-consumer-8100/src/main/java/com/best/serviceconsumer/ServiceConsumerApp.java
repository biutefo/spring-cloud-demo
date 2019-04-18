package com.best.serviceconsumer;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
//@EnableDiscoveryClient
//@EnableCircuitBreaker
@SpringCloudApplication
@EnableFeignClients
public class ServiceConsumerApp {
	public static void main(String[] args) {
		SpringApplication.run(ServiceConsumerApp.class);
	}

	@Bean
	public RestTemplate restTemplate(){
		return  new RestTemplate();
	}
	@Bean
	@LoadBalanced
	public RestTemplate loadBalancedRestTemplate(){
		return  new RestTemplate();
	}

}