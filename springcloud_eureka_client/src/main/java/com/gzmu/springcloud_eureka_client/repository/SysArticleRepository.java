package com.gzmu.springcloud_eureka_client.repository;

import com.gzmu.springcloud_eureka_client.entity.SysArticle;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @className: SysArticleRepository
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:05 19-4-22
 * @modified:
 */
@RepositoryRestResource
public interface SysArticleRepository extends BaseRepository<SysArticle, Integer> {
}
