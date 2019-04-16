package com.best.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**@SpringCloudApplication=
 * @SpringBootApplication+
 * @EnableDiscoveryClient+
 * @EnableCircuitBreaker
 */
@SpringCloudApplication
@EnableZuulProxy
public class ZuulApp {
	public static void main(String[] args) {
		SpringApplication.run(ZuulApp.class);
	}
}
