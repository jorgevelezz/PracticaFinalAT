package com.example.demo.DTO;

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
	@Size(min = 3, message = "El campo nombre tiene que tener un mínimo de 3 caracteres")
	private String nombre;
	
	private Universo universo;
	
	private boolean vivo;

	@Override
	public void matar() {this.vivo=false;}

	@Override
	public void resucitar() {this.vivo=true;}
}
