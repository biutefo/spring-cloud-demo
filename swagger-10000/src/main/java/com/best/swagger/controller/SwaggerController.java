package com.best.swagger.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@Api
@RestController
public class SwaggerController {

	@ApiOperation("swagger-demo")
	@GetMapping("/swagger")
	public String helloSwagger() {
		return "Hello Swagger!";
	}

	@ApiOperation("Say hello.")
	@ApiImplicitParam(name = "name",value = "姓名",required = true,dataType = "String")
	//@PostMapping("/{name}") 会覆盖swagger的首页请求地址 -> /swagger-ui.html 不能这么写
	@PostMapping("/hello/{name}")
	public String sayHello(@PathVariable String name) {
		return "Hello,"+name+"!";
	}
}
