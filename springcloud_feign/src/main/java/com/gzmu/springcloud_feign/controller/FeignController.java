package com.gzmu.springcloud_feign.controller;

import com.gzmu.springcloud_feign.service.FeignDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FeignController {
    //编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
    @Autowired
    FeignDemo feignDemo;

    @GetMapping("/feign")
    public String feign(@RequestParam(value = "name", defaultValue = "谢印") String name){
        return  feignDemo.feign(name);
    }
}
