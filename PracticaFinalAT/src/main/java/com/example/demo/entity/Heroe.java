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

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="Heroe")
@Getter
@Setter
public class Heroe implements IHeroe,Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "heroeId", nullable=false, unique=true) 
	@GeneratedValue( strategy = GenerationType.SEQUENCE) 
	private Integer heroeId;
	
	@NotNull(message = "El campo nombre no puede ser nulo")
	@Column(name = "nombre", nullable=false)
	@Getter
	private String nombre;
	
	@NotNull(message = "El campo universo no puede ser nulo")
	@Column(name = "universo", nullable=false)
	private String universo;
	
	
	@Column(name = "vivo", nullable=false)
	private boolean vivo;
	
	
	@Override
	public void matar() {this.vivo=false;}

	@Override
	public void resucitar() {this.vivo=true;}
	


		

}
