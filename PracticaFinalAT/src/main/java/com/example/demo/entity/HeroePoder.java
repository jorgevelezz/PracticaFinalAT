package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "HeroePoder")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class HeroePoder implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	private HeroePoderKey id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "heroeId", nullable = false, insertable = false, updatable = false)
	private Heroe heroe;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "poderId", nullable = false, insertable = false, updatable = false)
	private Poder poder;

}
