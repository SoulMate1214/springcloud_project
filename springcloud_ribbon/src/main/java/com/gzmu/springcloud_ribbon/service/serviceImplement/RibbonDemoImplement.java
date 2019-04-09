package com.gzmu.springcloud_ribbon.service.serviceImplement;
import com.gzmu.springcloud_ribbon.service.RibbonDemo;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class RibbonDemoImplement implements RibbonDemo {

    @Autowired
    RestTemplate restTemplate;

    /**
     * @LoadBalanced使得只需请求服务名就可以均衡访问url
     * @HystrixCommand表示访问失败时跳转方法hystrix
     * @param name
     * @return
     */
    @HystrixCommand(fallbackMethod = "hystrix")
    public String ribbon(String name) {
        return restTemplate.getForObject("http://springcloud-eureka-client/helloWorld?name="+name,String.class);
    }

    @Override
    public String hystrix(String name) {
        return "你好"+ name +"我是ribbon里的熔断器，你访问的服务生病了，我来告诉你一声";
    }
}
