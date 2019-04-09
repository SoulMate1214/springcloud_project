package com.gzmu.springcloud_zuul;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

/**
 * @EnableZuulProxy表明自己是API路由网关，开启zuul功能
 */
@EnableZuulProxy
@EnableEurekaClient
@EnableDiscoveryClient
@SpringBootApplication
public class SpringcloudZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudZuulApplication.class, args);
    }

}
