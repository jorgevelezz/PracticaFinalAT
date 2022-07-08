package com.demo.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Heroe;
import com.example.demo.entity.Poder;

public interface PoderService {
	 
	 Iterable<Poder> findAll();
	 
	 void save(Poder poder);
	 
	 void delete(Poder poder);
	 
	 Optional<Poder> findById(Integer id);
	 
	 

}
