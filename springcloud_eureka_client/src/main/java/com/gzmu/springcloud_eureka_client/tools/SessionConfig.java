package com.gzmu.springcloud_eureka_client.tools;

import org.springframework.context.annotation.Configuration;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

/**
 * maxInactiveIntervalInSeconds: 设置 Session 失效时间
 * 使用 Redis Session 之后，
 * 原 Spring Boot 的 server.session.timeout 属性不再生效。
 */
@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 86400*30)
public class SessionConfig {
}
