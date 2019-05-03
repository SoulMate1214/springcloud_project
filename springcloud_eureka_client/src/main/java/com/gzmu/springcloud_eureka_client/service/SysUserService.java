package com.gzmu.springcloud_eureka_client.service;

import com.gzmu.springcloud_eureka_client.entity.SysUser;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
/**
 * @className: SysUserService
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:13 19-4-22
 * @modified:
 */
public interface SysUserService extends BaseService {
    /**
     * 条件分页查询
     *
     * @param name
     * @param pageable
     * @return
     */
    Page<SysUser> findByNameLike(String name, Pageable pageable);
}
