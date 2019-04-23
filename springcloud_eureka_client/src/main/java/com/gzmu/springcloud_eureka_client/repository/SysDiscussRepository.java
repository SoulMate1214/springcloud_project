package com.gzmu.springcloud_eureka_client.repository;

import com.gzmu.springcloud_eureka_client.entity.SysDiscuss;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @className: SysDiscussRepository
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:04 19-4-22
 * @modified:
 */
@RepositoryRestResource
public interface SysDiscussRepository extends BaseRepository<SysDiscuss, Integer> {
}
