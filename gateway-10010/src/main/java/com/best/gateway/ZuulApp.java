package com.best.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Profile;

/**@SpringCloudApplication=
 * @SpringBootApplication+
 * @EnableDiscoveryClient+
 * @EnableCircuitBreaker
 */

@Profile("eureka-zuu")
//@SpringCloudApplication
//@EnableZuulProxy
public class ZuulApp {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class);
	}
}
