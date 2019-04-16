package com.gzmu.springcloud_eureka_client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.web.client.RestTemplate;

/**
 * 表明我是服务提供者，向发现者(服务中心)提出注册
 *
 * @EnableDiscoveryClient和@EnableEurekaClient都是允许当前服务被发现 前者是针对不同服务中心，后者是针对Eureka服务中心
 * @EnableCaching开启缓存
 * @EnableScheduling开启任务定时调度
 */
@EnableDiscoveryClient
@EnableEurekaClient
@EnableScheduling
@EnableCaching
@SpringBootApplication
@EnableCircuitBreaker
@EnableHystrix
@EnableHystrixDashboard
public class SpringcloudEurekaClientApplication {
    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaClientApplication.class, args);
    }

    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
