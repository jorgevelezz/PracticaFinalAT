package com.example.demo;

import static org.mockito.Mockito.when;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.mockito.junit.jupiter.MockitoExtension;

import com.demo.example.service.impl.PoderServiceImpl;
import com.example.demo.entity.Heroe;
import com.example.demo.entity.Poder;
import com.example.demo.entity.Universo;
import com.example.demo.repos.RepHeroes;
import com.example.demo.repos.RepPoderes;

@ExtendWith(MockitoExtension.class)
public class TestUnitarioPoderService {
	
	@InjectMocks
	PoderServiceImpl poderService;
	
	@Mock
	RepPoderes repPoderes;
	
	private Map<Integer, Poder> poderes;
	private Integer id;
	private Poder expectedPoder;
	
	@BeforeEach
	void setup_test() {
		
		poderes = new HashMap<>();
		
		poderes.put(1,new Poder(Integer.valueOf(1),"Rayo", Integer.valueOf(100), "Daño Magico"));

		poderes.put(2,new Poder(Integer.valueOf(1),"Patada", Integer.valueOf(50), "Daño Fisico"));

		// INIT TEST VARIABLES	
		
		id = Integer.valueOf(1);
		expectedPoder = poderes.get(1);
		
	}
	
	@Test
	@DisplayName("Test para buscar un heroe")
	void test_buscarHeroe() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA Y RESULTADOS
		Integer poderIdParam = Integer.valueOf(1);
		Optional<Poder> valorEsperado = Optional.of(new Poder(Integer.valueOf(1),"Patada", Integer.valueOf(50), "Daño Fisico"));
		Integer valorIncorrecto = Integer.valueOf("9");
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		// BDDMockito.given(repository.buscarPelicula(id)).willReturn(valorEsperado);
		// Mockito.when(repository.buscarPelicula(anyInt())).thenReturn((any(Pelicula.class)));
		// Mockito.when(repository.buscarPelicula(any(Integer.class))).thenReturn(any());
		
		when(poderService.findById(poderIdParam)).thenReturn(valorEsperado);
		
		
		// LLAMADA A MÉTODO A TESTEAR
		Optional<Poder> poder = poderService.findById(poderIdParam);		
		
		// COMPROBACIONES DEL RESULTADO ESPERADO
		assertNotNull(poder);
		assertEquals(poderIdParam, poder.get().getPoderId());
		assertNotEquals(valorIncorrecto, poder.get().getPoderId());
	}
	
	

}
