package com.example.demo.entity;

import java.util.List;

public interface IHeroe {
	
	String getNombre();
	
	Poder getPoder();
	
	boolean isVivo();
	
	String getUniverso();
	
	void setNombre(String nombre);
	
	void setPoder(Poder poder);
	
	void matar();
	
	void resucitar();
	
	
	
	
	

}
