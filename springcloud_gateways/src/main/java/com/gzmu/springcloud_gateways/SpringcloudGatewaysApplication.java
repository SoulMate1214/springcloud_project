package com.gzmu.springcloud_gateways;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * 我是服务提供者
 */
@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
public class SpringcloudGatewaysApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudGatewaysApplication.class, args);
    }

}
