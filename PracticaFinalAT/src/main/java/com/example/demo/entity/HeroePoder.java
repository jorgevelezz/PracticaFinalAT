package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "HeroePoder")
public class HeroePoder implements Serializable {
	
	@Id
	private HeroePoderKey id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "heroeId", nullable = false, insertable = false, updatable = false)
	private Heroe heroe;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poderId", nullable = false, insertable = false, updatable = false)
	private Poder poder;

	
	public Heroe getHeroe() {return heroe;}

	public void setHeroe(Heroe heroe) {this.heroe = heroe;}

	public Poder getPoder() {return poder;}

	public void setPoder(Poder poder) {this.poder = poder;}

	public HeroePoderKey getId() {return id;}

	public void setId(HeroePoderKey id) {this.id = id;}
	
}
