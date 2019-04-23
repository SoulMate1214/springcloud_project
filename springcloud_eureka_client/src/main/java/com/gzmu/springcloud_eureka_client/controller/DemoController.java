package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.entity.Demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
    final
    Demo demo;

    @Autowired
    public DemoController(Demo demo) {
        this.demo = demo;
    }

    @RequestMapping("/user")
    public String index() {
        return demo.toString();
    }
}

