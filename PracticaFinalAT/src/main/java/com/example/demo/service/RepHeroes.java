package com.example.demo.service;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Heroe;

@Repository
public interface RepHeroes extends CrudRepository<Heroe,Integer>{


}