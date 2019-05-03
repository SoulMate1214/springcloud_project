package com.gzmu.springcloud_eureka_client.repository;

import com.gzmu.springcloud_eureka_client.entity.SysClassify;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @className: SysClassifyRepository
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:04 19-4-22
 * @modified:
 */
@RepositoryRestResource(path="classify")
public interface SysClassifyRepository extends BaseRepository<SysClassify, Integer> {
}
