package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class PoderDTO {
	

	private Integer poderId;
	
	
	@NotNull(message = "El campo nombre no puede ser nulo")
	@Size(min = 3, max=15, message = "El nombre tiene que estar entre 3-15 caracteres")
	private String nombre;
	
	@NotNull(message = "El campo de daño no puede ser nulo")
	private Integer dano;
	
	@NotNull(message = "El campo de tipo de daño no puede ser nulo")
	private String tipoDano;

}
