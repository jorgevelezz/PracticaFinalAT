package com.demo.example.service.impl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.example.service.PoderService;
import com.example.demo.entity.Poder;
import com.example.demo.repos.RepPoderes;


@Service
public class PoderServiceImpl implements PoderService{
	

	@Autowired
	private RepPoderes rp;

	@Override
	public Iterable<Poder> findAll() {
		
		return rp.findAll();
		
	}

	@Override
	public void save(Poder poder) {
		rp.save(poder);
		
	}

	@Override
	public void delete(Poder poder) {
		rp.delete(poder);
		
	}

	@Override
	public Optional<Poder> findById(Integer id) {
		
		return rp.findById(id);
	}
	
	
	

	


}
