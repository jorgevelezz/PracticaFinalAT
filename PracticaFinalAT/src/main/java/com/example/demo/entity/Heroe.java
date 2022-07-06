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
import javax.validation.constraints.Size;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Heroe")
@Data
public class Heroe implements IHeroe,Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "heroeId", nullable=false, unique=true) 
	@GeneratedValue( strategy = GenerationType.SEQUENCE) 
	private Integer heroeId;
	
	@NotNull(message = "El campo nombre no puede ser nulo")
	@Column(name = "nombre", nullable=false)
	private String nombre;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn( name = "universo", nullable=false)
	@NotNull(message = "El campo universo no puede ser nulo")
	private Universo universo;
	
	@Column(name = "vivo", nullable=false)
	private boolean vivo;
	
	
	@Override
	public void matar() {this.vivo=false;}

	@Override
	public void resucitar() {this.vivo=true;}
		

}
