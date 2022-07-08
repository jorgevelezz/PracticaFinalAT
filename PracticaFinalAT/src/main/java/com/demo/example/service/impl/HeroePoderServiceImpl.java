package com.demo.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.service.HeroePoderService;
import com.demo.example.service.HeroeService;
import com.example.demo.entity.Heroe;
import com.example.demo.entity.HeroePoder;
import com.example.demo.entity.HeroePoderKey;
import com.example.demo.entity.Universo;
import com.example.demo.repos.RepHeroePoder;
import com.example.demo.repos.RepHeroes;


@Service
public class HeroePoderServiceImpl implements HeroePoderService{
	

	@Autowired
	private RepHeroePoder rhp;

	@Override
	public Iterable<HeroePoder> findAll() {
		
		return rhp.findAll();
	}

	@Override
	public void save(HeroePoder heroePoder) {
		rhp.save(heroePoder);
		
	}

	@Override
	public void delete(HeroePoder heroePoder) {
		rhp.delete(heroePoder);
		
	}

	@Override
	public List<HeroePoder> findByHeroe(Heroe heroe) {
		
		return rhp.findByHeroe(heroe);
	}

	@Override
	public void deletePoderHeroe(HeroePoderKey heroePoderKey) {
		rhp.deletePoderHeroe(heroePoderKey);
		
	}

	@Override
	public void deleteAllPoderHeroe(Heroe heroe) {
		
		rhp.deleteAllPoderHeroe(heroe);
		
	}
	

	
	

}
