package com.example.demo.entity;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;


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
	@Size(min = 3, message = "El campo nombre tiene que tener un mínimo de 3 caracteres")
	@Column(name = "nombre", nullable=false)
	private String nombre;
	
	@ManyToOne( fetch = FetchType.LAZY)
	@JoinColumn( name = "universo", nullable=false)
	@NotNull(message = "El campo universo no puede ser nulo")
	private Universo universo;
	
	@Column(name = "vivo", nullable=false)
	private boolean vivo;
	
	 @OneToMany(fetch = FetchType.LAZY)  
	 @JoinColumn( name = "heroeId", nullable=false , insertable = false, updatable = false)
	 private List<HeroePoder> heroesPoder; 
	
	@Override
	public void matar() {this.vivo=false;}

	@Override
	public void resucitar() {this.vivo=true;}
		

}
