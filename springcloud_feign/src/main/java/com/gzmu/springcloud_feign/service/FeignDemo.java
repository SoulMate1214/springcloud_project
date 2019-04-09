package com.gzmu.springcloud_feign.service;

import com.gzmu.springcloud_feign.service.serviceImplement.FeignDemoImplement;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * 这种负载均衡将更简单,不需要通过RestTemplate绑定负载周期
 * feign自带熔断器，只需加上fallback=指定类即可
 */
@FeignClient(value = "springcloud-eureka-client",fallback = FeignDemoImplement.class)
public interface FeignDemo {
    /**
     *
     * @param name
     * @return
     */
    @RequestMapping(value = "/helloWorld",method = RequestMethod.GET)
    String feign (String name);
}
