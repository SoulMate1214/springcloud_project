package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.service.SysPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: SysPageController
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:34 19-4-22
 * @modified:
 */
@RepositoryRestController
@RequestMapping("/page")
public class SysPageController {
    final
    SysPageService sysPageService;

    @Autowired
    public SysPageController(SysPageService sysPageService) {
        this.sysPageService = sysPageService;
    }
}
