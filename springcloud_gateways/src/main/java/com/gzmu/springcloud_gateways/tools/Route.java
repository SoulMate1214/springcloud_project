package com.gzmu.springcloud_gateways.tools;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RestController;

import java.util.function.Predicate;

@RestController
public class Route {
    // Bean使得加入到io容器
    @Bean
    /**
     * RouteLocatorBuilder类是用于创建路由的
     * 除了创建路由,RouteLocatorBuilder可以让你添加各种predicates和filters
     * predicates是断言，也就是规则，达到某某规则才继续执行
     * filter是过滤器
     * 也可以在配置文件创建路由
     */
    public RouteLocator myRoute (RouteLocatorBuilder routeLocatorBuilder){
        return routeLocatorBuilder.routes()
                // 创建一个路由
                .route(p -> p
                     // 路由请求路劲
                    .path("/get")
                     // 过滤器，这里表示在rout执行前添加了一个header的filter，键name 值soul
                    .filters(f -> f.addRequestHeader("name","soul"))
                     // 路由转发的路劲或者链接
                    .uri("http://httpbin.org:80"))
                // 创建另一个路由
                // 只要不是/get路劲都将到这个路由
                .route(p -> p
                     // 路由是自上而下的链状请求。第二个路由如果不加path就默认使用除上述路由其他所有路径的二级路径
                     // .path("/insert")
                     // 标准断言
                     // .predicate(Predicate.isEqual("必须有我才能通过"))
                     // host断言，必须带有host请求为*.hystrix.com才允许执行路由
                      .host("*.hystrix.com")
                     // gateway的hystrix熔断器是以过滤器形式体现
                    .filters(f -> f
                         // 添加一个熔断器The method is not allowed for the requested URL
                        .hystrix(config -> config
                             // 设置name
                            .setName("我是熔断器")
                             // 设置熔断后的重定向路径
                            .setFallbackUri("forward:/fallback")))
                     //路由转发路劲
                    .uri("http://httpbin.org:80"))
                // 一个build对应创建上面所有的路由
                .build();
    }
}
