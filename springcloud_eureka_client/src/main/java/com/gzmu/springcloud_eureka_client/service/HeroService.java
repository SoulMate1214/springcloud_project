package com.gzmu.springcloud_eureka_client.service;

import com.gzmu.springcloud_eureka_client.model.Hero;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Collection;
import java.util.List;

public interface HeroService {

    /**
     * 增加
     * @param hero
     */
    void save(Hero hero);

    /**
     * 删除
     * @param id
     */
    void deleteById(int id);
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
