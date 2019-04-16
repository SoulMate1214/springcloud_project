package com.gzmu.springcloud_eureka_client.tools;

import com.gzmu.springcloud_eureka_client.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class RoutConfig {

    final
    HeroService heroService;

    @Autowired
    public RoutConfig(HeroService heroService) {
        this.heroService = heroService;
    }

    /**
     * 主页
     *
     * @return
     */
    @RequestMapping("/")
    private String index() {
        return "/index";
    }

    /**
     * 跳转登录界面
     *
     * @return
     */
    @RequestMapping("/login")
    private String login() {
        return "/login";
    }

    /**
     * 模板后台主页
     *
     * @return
     */
    @RequestMapping("/index1")
    private String index1() {
        return "/index1";
    }

    /**
     * 模板动态表格
     *
     * @return
     */
    @RequestMapping("/dynamic_table")
    private String dynamic_table() {
        return "/dynamic_table";
    }

    /**
     * 模板静态表格
     *
     * @return
     */
    @RequestMapping("/static_table")
    private String static_table() {
        return "/static_table";
    }
}
