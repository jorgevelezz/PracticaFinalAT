package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.HeroePoder;

@Repository
public interface RepHeroePoder extends CrudRepository<HeroePoder,Integer>{


}