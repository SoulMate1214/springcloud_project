package com.gzmu.springcloud_eureka_client.tools;

import com.gzmu.springcloud_eureka_client.model.Hero;
import com.gzmu.springcloud_eureka_client.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

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
     * 跳转数据页面
     * 模糊分页
     *
     * @param name
     * @param nowPage
     * @param model
     * @return
     */
    @RequestMapping("/getPage")
    public String getPage(String name, Integer nowPage, Model model) {
        if (nowPage == null) {
            nowPage = 0;
        }

        PageRequest pr = PageRequest.of(nowPage, 10, Sort.by(Sort.Direction.ASC, "id"));
        Page<Hero> page = heroService.findByNameLike(name, pr);

        List<Hero> list = page.getContent();

        // 获取总页数
        int pageCount = page.getTotalPages();
        int[] pageBtns = new int[pageCount];
        for (int i = 0; i < pageBtns.length; i++) {
            pageBtns[i] = i + 1;
        }

        model.addAttribute("heroList", list);
        model.addAttribute("pageCount", pageCount);
        model.addAttribute("total", page.getTotalElements());
        model.addAttribute("pageNow", page.getNumber());
        model.addAttribute("name", name);
        model.addAttribute("pageBtns", pageBtns);
        return "/main";
    }


    /**
     * 修改
     *
     * @param
     * @return
     */
    @RequestMapping(path = "/update")
    public String update(Hero hero, Model model) {
        model.addAttribute("hero", hero);
        return "/update";
    }
}
