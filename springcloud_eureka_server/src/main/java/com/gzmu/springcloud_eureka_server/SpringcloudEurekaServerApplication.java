package com.gzmu.springcloud_eureka_server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * 表明我是服务发现者(服务中心)
 * @EnableEurekaServer和@EnableEurekaClient区别在于：
 * 前者引入了@Import({EurekaServerMarkerConfiguration.class})注解
 * 它会使得EurekaServer周期开始
 */
@EnableEurekaServer
@SpringBootApplication
public class SpringcloudEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudEurekaServerApplication.class, args);
    }

}
