package com.gzmu.springcloud_eureka_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldController {

    @Value("${server.port}")
    String port;

    @RequestMapping("/helloWorld")
    public String hello(@RequestParam(value = "name", defaultValue = "谢印") String name) {
        return "你好 " + name + "\t我是服务提供者，我来自端口:" + port;
    }

}
