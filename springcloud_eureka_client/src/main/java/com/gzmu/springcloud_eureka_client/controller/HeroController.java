package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.model.Hero;
import com.gzmu.springcloud_eureka_client.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.UUID;

/**
 * @CacheConfig缓存配置
 * @Cacheable将查询结果缓存到redis中，（key="#p0"）指定传入的第一个参数作为redis的key。
 * @CachePut，指定key，将更新的结果同步到redis中
 * @CacheEvict，指定key，删除缓存数据，allEntries=true,方法调用后将立即清除缓存
 */
@Controller
public class HeroController {

    private final HeroService heroService;

    @Autowired
    public HeroController(HeroService heroService) {
        this.heroService = heroService;
    }

    /**
     * 登录验证
     *
     * @param name
     * @param appellation
     * @param request
     * @return
     */
    @PostMapping("/loginSubmit")
    public HttpEntity<?> loginSubmit(@RequestParam("name") String name, @RequestParam("appellation") String appellation, HttpServletRequest request) {
        List<Hero> heroList = heroService.findAll();
        for (Hero i : heroList) {
            if (i.getName().equals(name) && i.getAppellation().equals(appellation)) {
                return ResponseEntity.ok().build();
            }
        }
        return ResponseEntity.status(500).build();
    }

    /**
     * 增加
     *
     * @param hero
     * @return
     */
    @PostMapping(path = "/save")
    @ResponseBody
    public Hero save(Hero hero) {
        heroService.save(hero);
        return hero;
    }

    /**
     * 删除
     *
     * @param id
     * @return
     */
    @RequestMapping(path = "/delete")
    public String delete(@RequestParam("id") String id, @RequestParam("nowPage") String nowPage) {
        heroService.deleteById(Integer.parseInt(id));
        return "redirect:/getPage?nowPage=" + nowPage;
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

    /**
     * 根据名字查询
     *
     * @return
     */
    @PostMapping(path = "/findByName")
    public String findByName(@RequestParam("name") String name, Model model) {
        List<Hero> heroes = heroService.findByNameLike(name);
        model.addAttribute("heroList", heroes);
        model.addAttribute("pageCount", 1);
        model.addAttribute("total", 1);
        model.addAttribute("pageNow", 1);
        model.addAttribute("pageBtns", 1);
        return "/main";
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
        model.addAttribute("pageBtns", pageBtns);
        return "/main";
    }

    /**
     * Redis的Session测试,需要把@Controller改为@RestController
     * 获取session的uid
     *
     * @param session
     * @return
     */
    @RequestMapping("/uid")
    String uid(HttpSession session) {
        UUID uid = (UUID) session.getAttribute("uid");
        if (uid == null) {
            uid = UUID.randomUUID();
        }
        session.setAttribute("uid", uid);
        return session.getId();
    }
}
