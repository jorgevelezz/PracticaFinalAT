package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.demo.dto.HeroeDTO;
import com.example.demo.entity.Heroe;

@Repository
public interface RepHeroes extends CrudRepository<Heroe,Integer>{
	
	 @Query("SELECT e from Heroe e where e.nombre =:name ")     
	 List<Heroe> findByName(@Param("name") String name);


}