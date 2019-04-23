package com.gzmu.springcloud_eureka_client.controller;

import brave.sampler.Sampler;
import com.gzmu.springcloud_eureka_client.SpringcloudEurekaClientApplication;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * 这个类是测试用于springCloud的
 * 端口调用测试
 * 负载均衡测试
 * 服务链路追踪测试（此处是最底层服务）
 */
@RestController
public class HelloWorldController {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * log信息打印
     */
    private static final Logger LOG = Logger.getLogger(SpringcloudEurekaClientApplication.class.getName());

    /**
     * 端口参数获取
     */
    @Value("${server.port}")
    String port;

    /**
     * /helloWorld请求
     *
     * @param name
     * @return
     */
    @RequestMapping("/helloWorld")
    public String hello(@RequestParam(value = "name", defaultValue = "谢印") String name) {
        return "你好 " + name + "\t我是服务提供者，我来自端口:" + port;
    }

    /**
     * we请求调用了feign服务的game请求
     *
     * @return
     */
    @RequestMapping("/we")
    public String we(@RequestParam(value = "sever") String server) {
        LOG.log(Level.INFO, "来自 " + server + " 服务的请求");
        return restTemplate.getForObject("http://localhost:8884/game?server=springcloud-eureka-client", String.class);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }

    /**
     * 聚合熔断监控测试
     */
    @RequestMapping("/hi")
    @HystrixCommand(fallbackMethod = "hiError")
    public String home(@RequestParam(value = "name", defaultValue = "谢印") String name) {
        return "hi " + name + " ,i am from port:" + port;
    }

    public String hiError(String name) {
        return "hi,"+name+",sorry,error!";
    }
}
