package com.gzmu.springcloud_eureka_client.repository;

import com.gzmu.springcloud_eureka_client.entity.BaseEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.NoRepositoryBean;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RestResource;

import javax.transaction.Transactional;

/**
 * @param <T>  实体类
 * @param <ID> 主键类型
 * @className: BaseRepository(持久化映射基类)
 * @author: 冫soul丶
 * @version: 1.0
 * @date: created in 下午4:36 19-4-22
 * @modified:
 */

@NoRepositoryBean
public interface BaseRepository<T extends BaseEntity, ID> extends JpaRepository<T, ID>, JpaSpecificationExecutor<T> {

    /**
     * 查询所有数据
     *
     * @param pageable 分页
     * @return 结果
     */
    @RestResource(path = "all", rel = "all")
    @Query(value = "select * from #{#entityName} ", countQuery = "select count(*) from #{#entityName}", nativeQuery = true)
    Page<T> findAllExist(Pageable pageable);

    /**
     * 真正删除一个数据
     *
     * @param id id
     */
    @Modifying
    @RestResource(exported = false)
    @Transactional(rollbackOn = Exception.class)
    @SuppressWarnings("all")
    @Query(value = "delete from #{#entityName} where id = :id", nativeQuery = true)
    void deleteExistById(@Param("id") ID id);


    /**
     * 禁用默认的删除方法
     *
     * @param id id
     */
    @Override
    default void deleteById(ID id) {
        deleteExistById(id);
    }
}
