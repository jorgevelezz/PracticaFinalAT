package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

@Entity
@Table(name="Heroe")
public class Heroe implements IHeroe,Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "heroeId", nullable=false, unique=true) 
	@GeneratedValue( strategy = GenerationType.IDENTITY) 
	private Integer heroeId;
	
	@NotNull(message = "El campo nombre no puede ser nulo")
	@Column(name = "nombre", nullable=false)
	private String nombre;
	
	@NotNull(message = "El campo universo no puede ser nulo")
	@Column(name = "universo", nullable=false)
	private String universo;
	
	
	@Column(name = "vivo", nullable=false)
	private boolean vivo;
	
	//Mapeo Plano
	/*
	@Column(name = "poder", nullable=false)
	private Integer poderId;
	*/
	
	//MAPEO DE RELACION
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn( name = "poderId", nullable=false)
	private Poder poder;
	
	
	@Override
	public String getNombre() {return this.nombre;}

	@Override
	public Poder getPoder() {return this.poder;}

	@Override
	public boolean isVivo() {return this.vivo;}
 
	@Override
	public String getUniverso() {return this.universo;}

	@Override
	public void setNombre(String nombre) {this.nombre = nombre;}

	@Override
	public void setPoder(Poder poder) {this.poder = poder;}

	@Override
	public void matar() {this.vivo=false;}

	@Override
	public void resucitar() {this.vivo=true;}
	


		

}
