package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.entity.Hero;
import com.gzmu.springcloud_eureka_client.entity.SysUser;
import com.gzmu.springcloud_eureka_client.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * @className: SysUserController
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:22 19-4-22
 * @modified:
 */
@RepositoryRestController
@RequestMapping("/user")
public class SysUserController {
    final
    SysUserService sysUserService;

    @Autowired
    public SysUserController(SysUserService sysUserService) {
        this.sysUserService = sysUserService;
    }

    @RequestMapping("/find")
    public Model find(String name, Integer nowPage, Model model) {
        if (nowPage == null) {
            nowPage = 0;
        }
        PageRequest pr = PageRequest.of(nowPage, 10, Sort.by(Sort.Direction.ASC, "id"));
        Page<SysUser> page = sysUserService.findByNameLike(name, pr);
        List<SysUser> list = page.getContent();
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
        return model;
    }
}
