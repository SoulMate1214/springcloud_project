package com.gzmu.springcloud_eureka_client.tools;

import org.apache.catalina.filters.RemoteIpFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 拦截器
 *
 * @author xieyin
 */
@Configuration
public class FilterConfig {
    @Bean
    public RemoteIpFilter remoteIpFilter() {
        return new RemoteIpFilter();
    }

    @Bean
    public FilterRegistrationBean testFilterRegistration() {
        FilterRegistrationBean registration = new FilterRegistrationBean();
        registration.setFilter(new MyFilter());
        registration.addUrlPatterns("/*");
        registration.addInitParameter("paramName", "paramValue");
        registration.setName("MyFilter");
        registration.setOrder(1);
        return registration;
    }

    public class MyFilter implements Filter {
        @Override
        public void destroy() {
            // TODO Auto-generated method stub
        }

        @Override
        public void doFilter(ServletRequest srequest, ServletResponse sresponse, FilterChain filterChain)
                throws IOException, ServletException {
            // TODO Auto-generated method stub
            HttpServletRequest request = (HttpServletRequest) srequest;
            //用户session是否存在
            boolean vlogin = request.getSession().getAttribute("heroList") == null;
            //是否需要进行拦截 true为需要 false为不需要
            boolean vUrl = false;
            String url = request.getRequestURI();
            List<String> urls = new ArrayList<>();
            //添加需要拦截的url
            urls.add("/main");
            for (String v_url : urls) {
                if (v_url.equals(url)) {
                    vUrl = true;
                    break;
                }
            }
            //验证登录
            if (vlogin && vUrl) {
                request.setAttribute("flag", "error");
                request.getRequestDispatcher("/login").forward(request, sresponse);
            }
            filterChain.doFilter(srequest, sresponse);
        }

        public void init(FilterConfig arg0) throws ServletException {
            // TODO Auto-generated method stub
        }
    }
}