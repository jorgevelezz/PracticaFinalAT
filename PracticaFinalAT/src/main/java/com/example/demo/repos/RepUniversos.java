package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.entity.Heroe;
import com.example.demo.entity.Universo;

@Repository
public interface RepUniversos extends CrudRepository<Universo,Integer>{


}