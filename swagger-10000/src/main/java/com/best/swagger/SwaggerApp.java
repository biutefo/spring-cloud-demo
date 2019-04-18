package com.best.swagger;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class SwaggerApp {
	//http://ip:port/swagger-ui.html
	public static void main(String[] args) {
		SpringApplication.run(SwaggerApp.class);
	}
}