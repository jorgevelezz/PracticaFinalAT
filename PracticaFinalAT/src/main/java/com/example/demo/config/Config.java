package com.example.demo.config;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.demo.example.service.HeroePoderService;
import com.demo.example.service.HeroeService;
import com.demo.example.service.PoderService;
import com.demo.example.service.UniversoService;
import com.demo.example.service.impl.HeroePoderServiceImpl;
import com.demo.example.service.impl.HeroeServiceImpl;
import com.demo.example.service.impl.PoderServiceImpl;
import com.demo.example.service.impl.UniversoServiceImpl;



@Configuration
@ComponentScan(basePackages = { "com.example.demo"})
@EntityScan("com.example.demo")  
public class Config {
	
	@Bean
	public HeroeService transactionService() {
	    return  new HeroeServiceImpl();
	}
	
	@Bean
	public PoderService transactionService2() {
	    return  new PoderServiceImpl();
	}
	
	@Bean
	public UniversoService transactionService3() {
	    return  new UniversoServiceImpl();
	}
	
	@Bean
	public HeroePoderService transactionService4() {
	    return  new HeroePoderServiceImpl();
	}
	

	

}
