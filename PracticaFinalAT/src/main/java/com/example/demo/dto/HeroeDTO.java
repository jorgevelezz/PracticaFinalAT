package com.example.demo.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import com.example.demo.entity.IHeroe;
import com.example.demo.entity.Universo;

import lombok.Data;

@Data
public class HeroeDTO implements IHeroe,Serializable{

	private static final long serialVersionUID = 1L;

	private Integer heroeId;

	@NotNull(message = "El campo nombre no puede ser nulo")
	@Size(min = 3, max=15, message = "El nombre tiene que estar entre 3-15 caracteres")
	private String nombre;
	
	@NotNull(message = "El campo universo no puede ser nulo")
	private Universo universo;
	
	private boolean vivo;

	@Override
	public void matar() {this.vivo=false;}

	@Override
	public void resucitar() {this.vivo=true;}
}
