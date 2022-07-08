package com.demo.example.service;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entity.Heroe;
import com.example.demo.entity.Universo;

public interface UniversoService {

	 
	 Iterable<Universo> findAll();
	 
	 void save(Universo universo);
	 
	 void delete(Universo universo);
	 
	 Optional<Universo> findById(Integer id);
	 
	 

}
