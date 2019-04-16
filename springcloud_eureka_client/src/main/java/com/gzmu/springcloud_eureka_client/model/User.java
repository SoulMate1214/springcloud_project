package com.gzmu.springcloud_eureka_client.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

/**
 * 加入io容器
 */
@Component

/**
 * 这个注解是加载别的自定义配置文件
 */
@PropertySource("classpath:random.properties")

/**
 * 这个注解是@Value的简化版，但是值不能有下划线和大写字母
 */
@ConfigurationProperties(prefix = "com.gzmu.springbootproject.model.user")

/**
 * 这个类是测试springboot一些配置文件的虚假模型,数据库并没有该表
 */
public class User {
    //    @Value("${com.gzmu.springbootproject.model.user.name}")
    private String name;
    //    @Value("${com.gzmu.springbootproject.model.user.message}")
    private String message;

    @Override
    public String toString() {
        return "user{" +
                "name='" + name + '\'' +
                ", message='" + message + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
