package com.gzmu.springcloud_ribbon;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

/**
 * 表明我是服务消费者，向发现者(服务中心)提出注册
 * @EnableDiscoveryClient和@EnableEurekaClient都是允许当前服务被发现
 * 前者是针对不同服务中心，后者是针对Eureka服务中心
 */
@EnableDiscoveryClient
@EnableEurekaClient
/**
 * 加入熔断器
 */
@EnableHystrix
/**
 * 熔断监控
 */
@EnableHystrixDashboard
@EnableCircuitBreaker
@SpringBootApplication
public class SpringcloudRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudRibbonApplication.class, args);
    }
    /**
     * 把RestTemplate请求类通过@LoadBalances构造成负载均衡器
     */
    @Bean
    @LoadBalanced
    RestTemplate restTemplate() {
        return new RestTemplate();
    }
}
