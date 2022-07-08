package com.example.demo.dto;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class UniversoDTO {
	
	private static final long serialVersionUID = 1L;
	

	private Integer universoId;

	@NotNull(message = "El campo de tipo de daño no puede ser nulo")
	@Size(min = 3, max=15, message = "El nombre tiene que estar entre 3-15 caracteres")
	private String nombre;
	
	@NotNull(message = "El campo dimension no puede ser nulo")
	@Size(min = 3, max=15, message = "La dimensión tiene que estar entre 3-15 caracteres")
	private String dimension;

}
