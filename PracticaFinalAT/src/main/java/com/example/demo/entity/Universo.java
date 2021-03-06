package com.example.demo.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="Universo")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Universo implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@Column(name = "universoId", nullable=false, unique=true) 
	@GeneratedValue( strategy = GenerationType.SEQUENCE) 
	private Integer universoId;
	
@NotNull(message = "El campo nombre no puede ser nulo")
	@Column(name = "nombre", nullable=false)
	private String nombre;
	
	@NotNull(message = "El campo dimension no puede ser nulo")
	@Column(name = "dimension", nullable=false)
	private String dimension;
	
	
	
	

}
