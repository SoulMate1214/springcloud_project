package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.model.Hero;
import com.gzmu.springcloud_eureka_client.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
@CacheConfig(cacheNames = "hero")
public class HeroController {

    private final HeroService heroService;
    private Hero hero;

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
     * 使用到缓存
     * @param hero
     * @return
     */
    @PostMapping(path = "/save")
    @ResponseBody
    @Cacheable(key ="'hero-key'")
    public Hero save(Hero hero) {
        heroService.save(hero);
        return hero;
    }

    /**
     * 全查
     *
     * @return
     */
    @PostMapping(path = "/findAll")
    public List<Hero> findAll() {
        return heroService.findAll();
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
     * Redis的Session测试,需要把@Controller改为@RestController
     * 获取session的uid
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
