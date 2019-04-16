package com.gzmu.springcloud_feign.controller;

import com.gzmu.springcloud_feign.SpringcloudFeignApplication;
import com.gzmu.springcloud_feign.service.FeignDemo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class FeignController {
    /**
     * log信息打印
     */
    private static final Logger LOG = Logger.getLogger(SpringcloudFeignApplication.class.getName());

    /**
     * 编译器报错，无视。 因为这个Bean是在程序启动的时候注入的，编译器感知不到，所以报错。
     */
    @Autowired
    FeignDemo feignDemo;


    @RequestMapping("/feign")
    public String feign(@RequestParam(value = "sever") String server) {
        LOG.log(Level.INFO, "来自 " + server + " 服务的请求");
        return feignDemo.feign(server);
    }

    @RequestMapping("/game")
    public String game(@RequestParam(value = "sever") String server) {
        LOG.log(Level.INFO, "来自 " + server + " 服务的请求");
        return "成功!服务调用情况:sleuth(begin)->feign(feign)->client(we)->feign(game)";
    }

}
