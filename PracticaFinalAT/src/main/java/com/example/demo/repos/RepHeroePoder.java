package com.example.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.entity.Heroe;
import com.example.demo.entity.HeroePoder;
import com.example.demo.entity.HeroePoderKey;

@Repository
public interface RepHeroePoder extends CrudRepository<HeroePoder,HeroePoderKey>{
	
	 @Query("SELECT e from HeroePoder e where e.heroe =:heroe ")     
	 List<HeroePoder> findByHeroe(@Param("heroe") Heroe heroe);
	 
	 @Modifying
	 @Transactional
	 @Query("delete from HeroePoder e where e.heroe=:heroe")     
	 void deleteAllPoderHeroe(@Param("heroe") Heroe heroe);

	 @Modifying
	 @Transactional
	 @Query("DELETE from HeroePoder e where e.id =:#{#id} ") 
	 void deletePoderHeroe(@Param("id") HeroePoderKey id);

}