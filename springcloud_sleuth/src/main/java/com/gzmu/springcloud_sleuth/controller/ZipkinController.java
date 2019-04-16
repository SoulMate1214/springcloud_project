package com.gzmu.springcloud_sleuth.controller;

import brave.sampler.Sampler;
import com.gzmu.springcloud_sleuth.SpringcloudSleuthApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
public class ZipkinController {
    @Autowired
    private RestTemplate restTemplate;

    @Bean
    public RestTemplate getRestTemplate() {
        return new RestTemplate();
    }

    /**
     * log信息打印
     */
    private static final Logger LOG = Logger.getLogger(SpringcloudSleuthApplication.class.getName());


    @RequestMapping("/begin")
    public String begin() {
        LOG.log(Level.INFO, "开始追踪 springcloud-sleth 服务");
        return restTemplate.getForObject("http://localhost:8884/feign?server=springcloud-sleth", String.class);
    }

    @Bean
    public Sampler defaultSampler() {
        return Sampler.ALWAYS_SAMPLE;
    }
}
