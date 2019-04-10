package com.gzmu.springcloud_config_client.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @RefreshScope动态刷新配置项
 */
@RestController
@RefreshScope
public class DemoPropertiesController {
    @Value("${foo}")
    String foo;
    @RequestMapping("/")
    public String getDemoProperties(){
        return foo;
    }
}
