package com.demo.example.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.service.HeroeService;
import com.demo.example.service.UniversoService;
import com.example.demo.entity.Heroe;
import com.example.demo.entity.Universo;
import com.example.demo.repos.RepHeroes;
import com.example.demo.repos.RepUniversos;


@Service
public class UniversoServiceImpl implements UniversoService{
	

	@Autowired
	private RepUniversos ru;

	@Override
	public Iterable<Universo> findAll() {return ru.findAll();}

	@Override
	public void save(Universo universo) {ru.save(universo);}

	@Override
	public void delete(Universo universo) {ru.delete(universo);}

	@Override
	public Optional<Universo> findById(Integer id) {return ru.findById(id);}
	
	


}
