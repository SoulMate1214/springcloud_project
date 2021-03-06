package com.gzmu.springcloud_eureka_client.repository;

import com.gzmu.springcloud_eureka_client.entity.SysUser;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @className: SysUserRepository
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午5:55 19-4-22
 * @modified:
 */
@RepositoryRestResource(path="user")
public interface SysUserRepository extends BaseRepository<SysUser, Integer> {
}
