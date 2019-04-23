package com.gzmu.springcloud_eureka_client.service.serviceImpl;

import com.gzmu.springcloud_eureka_client.repository.SysArticleRepository;
import com.gzmu.springcloud_eureka_client.service.SysArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: SysArticleServiceImpl
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:18 19-4-22
 * @modified:
 */
@Service
public class SysArticleServiceImpl implements SysArticleService {
    final
    SysArticleRepository sysArticleRepository;

    @Autowired
    public SysArticleServiceImpl(SysArticleRepository sysArticleRepository) {
        this.sysArticleRepository = sysArticleRepository;
    }
}
