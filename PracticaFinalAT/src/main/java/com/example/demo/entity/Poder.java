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


@Entity
@Table(name = "Poder")
public class Poder implements Serializable{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPoder")
	private Integer poderId;

	@Column(name = "nombre", nullable = false)
	private String nombre;
	
	@Column(name = "dano", nullable = false)
	private Integer dano;
	
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "heroeId")
	private Heroe heroe;
	
	@OneToMany()
	@JoinColumn(name = "poderId")
	private List<HeroePoder> heroes;
	

	public String getNombre() {return nombre;}

	public void setNombre(String nombre) {this.nombre = nombre;}

	public Integer getDamage() {return dano;}

	public void setDamage(Integer damage) {this.dano = damage;}
	
	public Integer getPoderId() {return poderId;}

	public void setPoderId(Integer poderId) {this.poderId = poderId;}
	
}
