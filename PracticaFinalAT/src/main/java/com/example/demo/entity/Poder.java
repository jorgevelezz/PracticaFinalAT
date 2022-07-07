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
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.Getter;
import lombok.Setter;


@Entity
@Table(name = "Poder")
@Getter
@Setter
public class Poder implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.SEQUENCE)
	@Column(name = "idPoder")
	private Integer poderId;

	@Column(name = "nombre", nullable = false)
	@NotNull(message = "El campo nombre no puede ser nulo")
	@Getter 
	private String nombre;
	
	
	@Column(name = "dano", nullable = false)
	@NotNull(message = "El campo de daño no puede ser nulo")
	private Integer dano;
	
	@Column(name = "tipo", nullable = false)
	@NotNull(message = "El campo de tipo de daño no puede ser nulo")
	private String tipoDano;
	
	 @OneToMany(fetch = FetchType.LAZY)  
	 @JoinColumn( name = "poderId", nullable=false , insertable = false, updatable = false)
	 private List<HeroePoder> heroesPoder; 

	
}
