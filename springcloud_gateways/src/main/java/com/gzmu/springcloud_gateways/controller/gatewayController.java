package com.gzmu.springcloud_gateways.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
public class gatewayController {
    // Mono是一个Reactive stream（反应流）
    @RequestMapping("/fallback")
    public Mono<String> fallback(){
        return Mono.just("被熔断");
    }
}
