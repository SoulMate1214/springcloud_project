package com.gzmu.springcloud_eureka_client.service.serviceImpl;

import com.gzmu.springcloud_eureka_client.repository.SysSettingRepository;
import com.gzmu.springcloud_eureka_client.service.SysSettingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @className: SysSettingServiceImpl
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:16 19-4-22
 * @modified:
 */
@Service
public class SysSettingServiceImpl implements SysSettingService {
    final
    SysSettingRepository sysSettingRepository;

    @Autowired
    public SysSettingServiceImpl(SysSettingRepository sysSettingRepository) {
        this.sysSettingRepository = sysSettingRepository;
    }
}
