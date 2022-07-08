package com.demo.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Heroe;
import com.example.demo.entity.HeroePoder;
import com.example.demo.entity.HeroePoderKey;
import com.example.demo.entity.Universo;

public interface HeroePoderService {

	 
	 Iterable<HeroePoder> findAll();
	 
	 void save(HeroePoder heroePoder);
	 
	 void delete(HeroePoder heroePoder);
	 
	 List<HeroePoder> findByHeroe(Heroe heroe);
	 
	 void deletePoderHeroe(HeroePoderKey heroePoderKey);
	 
	 void deleteAllPoderHeroe(Heroe heroe);
	 
	 

}
