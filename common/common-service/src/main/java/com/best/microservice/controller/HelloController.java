package com.best.microservice.controller;

import com.best.microservice.entity.HelloMsg;
import com.best.microservice.entity.Person;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@RestController =@Controller+ @ResponseBody
@RestController
@RequestMapping("sayHello")
public class HelloController {

	@GetMapping()
	//@ResponseBody-> 表示响应体默认转json 返回HelloMsg的json格式字符串
	/*public HelloMsg sayHello() {
		HelloMsg helloMsg = new HelloMsg();
		helloMsg.setMsg("Hello Spring Cloud!");
		return helloMsg;
	}*/

	//@ResponseBody-> 表示响应体默认转json 返回HelloMsg的json格式字符串
	public ResponseEntity<HelloMsg> sayHello() {
		Person person = new Person();
		person.setMame("Li Xin");
		person.setAge(21);
		HelloMsg helloMsg = new HelloMsg();
		helloMsg.setPerson(person);
		helloMsg.setMsg("Hello Spring Cloud!");
		ResponseEntity<HelloMsg> responseEntity = ResponseEntity.ok(helloMsg);
		return responseEntity;
	}
}
