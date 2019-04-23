package com.gzmu.springcloud_eureka_client.controller;

import com.gzmu.springcloud_eureka_client.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.RepositoryRestController;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @className: SysFileController
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:34 19-4-22
 * @modified:
 */
@RepositoryRestController
@RequestMapping("/file")
public class SysFileController {
    final
    SysFileService sysFileService;

    @Autowired
    public SysFileController(SysFileService sysFileService) {
        this.sysFileService = sysFileService;
    }
}
