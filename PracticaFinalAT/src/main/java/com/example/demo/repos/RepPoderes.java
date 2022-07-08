package com.example.demo.repos;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.example.demo.entity.Poder;

@Repository
public interface RepPoderes extends CrudRepository<Poder,Integer>{


}