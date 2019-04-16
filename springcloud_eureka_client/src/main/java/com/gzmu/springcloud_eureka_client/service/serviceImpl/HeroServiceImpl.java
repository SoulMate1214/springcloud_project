package com.gzmu.springcloud_eureka_client.service.serviceImpl;

import com.gzmu.springcloud_eureka_client.mapper.HeroMapper;
import com.gzmu.springcloud_eureka_client.model.Hero;
import com.gzmu.springcloud_eureka_client.service.HeroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;

@Service
@CacheConfig(cacheNames = "hero")
public class HeroServiceImpl implements HeroService {
    private final HeroMapper heroMapper;

    @Autowired
    public HeroServiceImpl(HeroMapper heroMapper) {
        this.heroMapper = heroMapper;
    }

    @Override
    @CacheEvict(key = "'insertHero-key'", allEntries = true)
    public void save(Hero hero) {
        heroMapper.save(hero);
    }

    @Override
    @CacheEvict(key = "'deleteHero-key'", allEntries = true)
    public void deleteById(int id) {
        heroMapper.deleteById(id);
    }

    @Override
    public Hero findHeroById(int id) {
        return heroMapper.findHeroById(id);
    }

    @Override
    public List<Hero> findHeroByName(String name) {
        return heroMapper.findHeroByName(name);
    }

    @Override
    public List<Hero> findByNameLike(String name) {
        return heroMapper.findByNameLike(name);
    }

    @Override
    public List<Hero> findByIdIn(Collection<Integer> ids) {
        return heroMapper.findByIdIn(ids);
    }

    @Override
    public List<Hero> findAll() {
        return heroMapper.findAll();
    }

    @Override
    @Cacheable(key = "'heroList-key'")
    public Page<Hero> findByNameLike(String name, Pageable pageable) {
        if (name == null || name == "") {
            name = "%%";
        } else {
            name = "%" + name + "%";
        }
        return heroMapper.findByNameLike(name, pageable);
    }
}
