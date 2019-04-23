package com.gzmu.springcloud_eureka_client.service.serviceImpl;

import com.gzmu.springcloud_eureka_client.repository.SysFileRepository;
import com.gzmu.springcloud_eureka_client.service.SysFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: SysFileServiceImpl
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:17 19-4-22
 * @modified:
 */
@Service
public class SysFileServiceImpl implements SysFileService {
    final
    SysFileRepository sysFileRepository;

    @Autowired
    public SysFileServiceImpl(SysFileRepository sysFileRepository) {
        this.sysFileRepository = sysFileRepository;
    }
}
