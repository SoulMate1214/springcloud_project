package com.gzmu.springcloud_eureka_client.mapper;

import com.gzmu.springcloud_eureka_client.model.Hero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface HeroMapper extends JpaRepository<Hero, Integer> {
    /**
     * 条件查询
     * 根据id查找
     * @param id
     * @return
     */
    Hero findHeroById(int id);

    /**
     * 条件查询
     * 根据name查找
     * @param name
     * @return
     */
    List<Hero> findHeroByName(String name);

    /**
     * 模糊查询
     * @param name
     * @return
     */
    List<Hero> findByNameLike(String name);

    /**
     * 批量查询
     * @param ids
     * @return
     */
    List<Hero> findByIdIn(Collection<Integer> ids);

    /**
     * 全查
     * @return
     */
    List<Hero> findAll();

    /**
     * 分页查询
     * @param name
     * @param pageable
     * @return
     */
    public Page<Hero> findByNameLike(String name, Pageable pageable);
}
