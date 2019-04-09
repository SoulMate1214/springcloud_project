package com.gzmu.springcloud_feign.service.serviceImplement;

import com.gzmu.springcloud_feign.service.FeignDemo;
import org.springframework.stereotype.Component;

/**
 * 实现类实现feign负载均衡借口，访问失败的时候将执行该类
 * @Component表示熔断器指向此类
 */
@Component
public class FeignDemoImplement implements FeignDemo {
    @Override
    public String feign(String name) {
        return "你好"+ name +"我是feign里的熔断器，你访问的服务生病了，我来告诉你一声";
    }
}
