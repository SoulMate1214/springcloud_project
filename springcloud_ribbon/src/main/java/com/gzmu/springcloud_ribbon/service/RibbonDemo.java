package com.gzmu.springcloud_ribbon.service;

public interface RibbonDemo {
    /**
     * ribbon负载均衡测试
     * @param name
     * @return
     */
    String ribbon(String name);

    /**
     * hystrix熔断器
     * @param name
     * @return
     */
    String hystrix(String name);
}
