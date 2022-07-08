package com.example.demo.DTO;

import java.io.Serializable;

import com.example.demo.entity.IHeroe;
import com.example.demo.entity.Universo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class HeroeDTO implements IHeroe,Serializable{

	private static final long serialVersionUID = 1L;

	private Integer heroeId;

	private String nombre;
	
	private Universo universo;
	
	private boolean vivo;

	@Override
	public void matar() {this.vivo=false;}

	@Override
	public void resucitar() {this.vivo=true;}
}
