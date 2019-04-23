package com.gzmu.springcloud_eureka_client.service.serviceImpl;

import com.gzmu.springcloud_eureka_client.repository.SysPageRepository;
import com.gzmu.springcloud_eureka_client.service.SysPageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: SysPageServiceImpl
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:16 19-4-22
 * @modified:
 */
@Service
public class SysPageServiceImpl implements SysPageService {
    final
    SysPageRepository sysPageRepository;

    @Autowired
    public SysPageServiceImpl(SysPageRepository sysPageRepository) {
        this.sysPageRepository = sysPageRepository;
    }
}
