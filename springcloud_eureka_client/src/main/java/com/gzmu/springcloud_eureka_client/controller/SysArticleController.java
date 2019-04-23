package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.service.SysArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: SysArticleController
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:35 19-4-22
 * @modified:
 */
@RepositoryRestController
@RequestMapping("/article")
public class SysArticleController {
    final
    SysArticleService sysArticleService;

    @Autowired
    public SysArticleController(SysArticleService sysArticleService) {
        this.sysArticleService = sysArticleService;
    }
}
