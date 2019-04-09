package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.model.Hero;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Cacheable;


@RestController
public class RedisController {
    private Hero hero;

//    @RequestMapping("/Redis")
//    @Cacheable(value = "hero-key")
//    public Hero getRedis(){
//
//    }
}
