package com.demo.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Heroe;

public interface HeroeService {
	
	 @Query("SELECT e from Heroe e where e.nombre =:name ")     
	 List<Heroe> findByName(@Param("name") String name);
	 
	 Iterable<Heroe> findAll();
	 
	 void save(Heroe heroe);
	 
	 void delete(Heroe heroe);
	 
	 Optional<Heroe> findById(Integer id);
	 
	 

}
