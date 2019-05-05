package com.gzmu.springcloud_eureka_client.service.serviceImpl;

import com.gzmu.springcloud_eureka_client.repository.SysUserRepository;
import com.gzmu.springcloud_eureka_client.service.SysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * @className: SysUserServiceImpl
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:15 19-4-22
 * @modified:
 */
@Service
public class SysUserServiceImpl implements SysUserService {
    final
    SysUserRepository sysUserRepository;

    @Autowired
    public SysUserServiceImpl(SysUserRepository sysUserRepository) {
        this.sysUserRepository = sysUserRepository;
    }

}
