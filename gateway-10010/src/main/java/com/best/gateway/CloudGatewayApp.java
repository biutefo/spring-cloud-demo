package com.best.gateway;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RequestMapping("cloud-gateway")
@RestController
@ActiveProfiles("consul-cloud-gateway")
@EnableDiscoveryClient
@SpringBootApplication
public class CloudGatewayApp {

    @Value("${spring.cloud.consul.host}")
    private String consulIp;

    @Value("${spring.cloud.consul.port}")
    private int consulPort;

    @Autowired
    private RestTemplate simpleRestTemplate;


    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(CloudGatewayApp.class);
//        System.out.println(context.getEnvironment().getActiveProfiles() == null);
    }

    @GetMapping("health")
    public String health() {
        return "health";
    }

    @GetMapping("deregister/{serviceId}")
    public String deregister(@PathVariable("serviceId") String serviceId) {
        //http://ip:8500/v1/agent/service/deregister/
        String deregisterUrl = new StringBuffer()
                .append("http://")
                .append(consulIp)
                .append(":")
                .append(consulPort)
                .append("/v1/agent/service/deregister/")
                .append("{1}")
                .toString();

        try {
            simpleRestTemplate.put(deregisterUrl, null, serviceId);
        } catch (Exception e) {
            return "wrong message:"+e.getMessage();
        }
        return "remove " + serviceId + "(if exits)";
    }


    @Bean
    @LoadBalanced
    public RestTemplate loadBalancedRestTemplate() {
        return new RestTemplate();
    }

    @Bean
    public RestTemplate simpleRestTemplate() {
        return new RestTemplate();
    }
}
