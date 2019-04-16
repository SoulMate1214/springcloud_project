package com.gzmu.springcloud_sleuth;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
public class SpringcloudSleuthApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringcloudSleuthApplication.class, args);
    }

}
