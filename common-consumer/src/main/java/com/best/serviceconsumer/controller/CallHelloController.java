package com.best.serviceconsumer.controller;

import com.best.microservice.entity.HelloMsg;
import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@Slf4j
@DefaultProperties(defaultFallback = "defaultFallback")//只能为无参方法
public class CallHelloController {

	@Autowired
	private RestTemplate restTemplate;

	private static final String serviceId = "common-service";

	/**
	 *
	 * //启动服务降级处理 -返回值类型需要相同
	 * 	  //1.若返回JSON最好在响应体中添加一个msg信息和success成功标志用来显示页面
	 * 	  //2.返回String如下
	 *        @HystrixCommand(fallbackMethod = "callHelloFail")
	 *    @GetMapping("callSayHello")
	 *    public ResponseEntity<HelloMsg> callHello() {
	 * 		HelloMsg helloMsg = restTemplate
	 * 				.getForObject("http://common-service/" + "sayHello", HelloMsg.class);
	 * 		log.info(helloMsg.toString());
	 * 		return ResponseEntity.ok(helloMsg);
	 *    }
	 *
	 * 	public ResponseEntity<HelloMsg> callHelloFail() {
	 * 		HelloMsg helloMsg = new HelloMsg();
	 * 		helloMsg.setMsg("不好意思 ，服务器挂了。");
	 * 		return ResponseEntity.status(500).body(helloMsg);
	 *    }
	 */

	//@HystrixCommand(fallbackMethod = "callHelloFallback")
	@HystrixCommand(commandProperties = {
			//配置超时时长 此处表示给方法配 类上也可配表示类所有方法的超时时长 yaml文件或者properties也可配表示全局的超时时长
			//优先级 方法上>类似>配置文件中
			@HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds" ,
					value = "3000")
	})
	@GetMapping("callSayHello")
	public ResponseEntity<String> callHello() throws InterruptedException {
		//Thread.sleep(3000);
		String url = "http://"+serviceId+"/sayHello";
		String helloMsg = restTemplate
				.getForObject(url, String.class);
		log.info(helloMsg.toString());
		return ResponseEntity.ok(helloMsg);
	}

	public ResponseEntity<String> callHelloFallback() {
		return ResponseEntity.ok("不好意思 ，callHello调用失败。");
	}
	public ResponseEntity<String> defaultFallback() {
		return ResponseEntity.ok("不好意思 ，服务器挂了。");
	}

}
