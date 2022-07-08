package com.demo.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.service.HeroeService;
import com.example.demo.entity.Heroe;
import com.example.demo.repos.RepHeroes;


@Service
public class HeroeServiceImpl implements HeroeService{
	

	@Autowired
	private RepHeroes rh;
	
	@Override
	public List<Heroe> findByName(String name) {
		
		List<Heroe> heroes = rh.findByName(name);
		
		return heroes;
	}

	@Override
	public Iterable<Heroe> findAll() {
		
		return rh.findAll();
	}

	@Override
	public void save(Heroe heroe) {
		
		rh.save(heroe);
		
	}

	@Override
	public void delete(Heroe heroe) {
		
		rh.delete(heroe);
		
	}

	@Override
	public Optional<Heroe> findById(Integer id){return rh.findById(id);}
	

	


}
