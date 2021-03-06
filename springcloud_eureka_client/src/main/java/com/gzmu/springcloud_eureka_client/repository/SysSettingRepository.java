package com.gzmu.springcloud_eureka_client.repository;

import com.gzmu.springcloud_eureka_client.entity.SysSetting;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

/**
 * @className: SysSettingRepository
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午6:01 19-4-22
 * @modified:
 */
@RepositoryRestResource(path="setting")
public interface SysSettingRepository extends BaseRepository<SysSetting, Integer> {
}
