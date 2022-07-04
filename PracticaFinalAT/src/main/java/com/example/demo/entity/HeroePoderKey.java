package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class HeroePoderKey implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(name = "heroeId")
	
	private Integer heroeId;
	
	@Column(name = "poderId")
	private Integer poderId;

	public Integer getHeroeId() {return heroeId;}

	public void setHeroeId(Integer heroeId) {this.heroeId = heroeId;}

	public Integer getPoderId() {return poderId;}

	public void setPoderId(Integer poderId) {this.poderId = poderId;}
	
}
