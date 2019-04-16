package com.gzmu.springcloud_ribbon.controller;


import com.gzmu.springcloud_ribbon.service.RibbonDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class RibbonDemoController {
    @Autowired
    RibbonDemo ribbonDemo;

    @GetMapping("/ribbon")
    public String ribbon(@RequestParam(value = "name", defaultValue = "谢印") String name) {
        return ribbonDemo.ribbon(name);
    }
}
