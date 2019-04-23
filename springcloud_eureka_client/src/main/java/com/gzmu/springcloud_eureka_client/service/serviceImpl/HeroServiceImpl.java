package com.gzmu.springcloud_eureka_client.service.serviceImpl;

import com.gzmu.springcloud_eureka_client.repository.HeroRepository;
import com.gzmu.springcloud_eureka_client.entity.Hero;
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
    private final HeroRepository heroRepository;

    @Autowired
    public HeroServiceImpl(HeroRepository heroRepository) {
        this.heroRepository = heroRepository;
    }

    @Override
    @CacheEvict(key = "'insertHero-key'", allEntries = true)
    public void save(Hero hero) {
        heroRepository.save(hero);
    }

    @Override
    @CacheEvict(key = "'deleteHero-key'", allEntries = true)
    public void deleteById(int id) {
        heroRepository.deleteById(id);
    }

    @Override
    public Hero findHeroById(int id) {
        return heroRepository.findHeroById(id);
    }

    @Override
    public List<Hero> findHeroByName(String name) {
        return heroRepository.findHeroByName(name);
    }

    @Override
    public List<Hero> findByNameLike(String name) {
        return heroRepository.findByNameLike(name);
    }

    @Override
    public List<Hero> findByIdIn(Collection<Integer> ids) {
        return heroRepository.findByIdIn(ids);
    }

    @Override
    public List<Hero> findAll() {
        return heroRepository.findAll();
    }

    @Override
    @Cacheable(key = "'heroList-key'")
    public Page<Hero> findByNameLike(String name, Pageable pageable) {
        if (name == null || name == "") {
            name = "%%";
        } else {
            name = "%" + name + "%";
        }
        return heroRepository.findByNameLike(name, pageable);
    }
}
