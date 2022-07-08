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

import com.demo.example.service.impl.HeroeServiceImpl;
import com.example.demo.entity.Heroe;
import com.example.demo.entity.Universo;
import com.example.demo.repos.RepHeroes;

@ExtendWith(MockitoExtension.class)
public class TestUnitarioHeroeService {
	
	@InjectMocks
	HeroeServiceImpl heroeService;
	
	@Mock
	RepHeroes repHeroes;
	
	private Map<Integer, Heroe> heroes;
	private Integer id;
	private Heroe expectedHeroe;
	
	@BeforeEach
	void setup_test() {
		
		heroes = new HashMap<>();
		
		heroes.put(1,new Heroe(Integer.valueOf(1),"superman", new Universo(1,"dc","Ce"), true));

		heroes.put(2,new Heroe(Integer.valueOf(1),"spiderman", new Universo(2,"marvel","Ce"), true));

		// INIT TEST VARIABLES	
		
		id = Integer.valueOf(1);
		expectedHeroe = heroes.get(1);
		
	}
	
	@Test
	@DisplayName("Test para buscar un heroe")
	void test_buscarHeroe() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA Y RESULTADOS
		Integer heroeIdParam = Integer.valueOf(1);
		Optional<Heroe> valorEsperado = Optional.of(new Heroe(Integer.valueOf(1),"superman", new Universo(1,"dc","Ce"), true));
		Integer valorIncorrecto = Integer.valueOf("9");
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		// BDDMockito.given(repository.buscarPelicula(id)).willReturn(valorEsperado);
		// Mockito.when(repository.buscarPelicula(anyInt())).thenReturn((any(Pelicula.class)));
		// Mockito.when(repository.buscarPelicula(any(Integer.class))).thenReturn(any());
		
		when(heroeService.findById(heroeIdParam)).thenReturn(valorEsperado);
		
		
		// LLAMADA A MÉTODO A TESTEAR
		Optional<Heroe> heroe = heroeService.findById(heroeIdParam);		
		
		// COMPROBACIONES DEL RESULTADO ESPERADO
		assertNotNull(heroe);
		assertEquals(heroeIdParam, heroe.get().getHeroeId());
		assertNotEquals(valorIncorrecto, heroe.get().getHeroeId());
	}
	
	@Test
	@DisplayName("Test para buscar un heroe por nombre")
	void test_buscarHeroeNombre() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA Y RESULTADOS
		String nombreHeroe = "superman";
		
		List<Heroe> valorEsperado = List.of(new Heroe(Integer.valueOf(1),"superman", new Universo(1,"dc","Ce"), true));
		String valorIncorrecto = "medusa";
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		// BDDMockito.given(repository.buscarPelicula(id)).willReturn(valorEsperado);
		// Mockito.when(repository.buscarPelicula(anyInt())).thenReturn((any(Pelicula.class)));
		// Mockito.when(repository.buscarPelicula(any(Integer.class))).thenReturn(any());
		
		when(heroeService.findByName(nombreHeroe)).thenReturn(valorEsperado);
		
		
		// LLAMADA A MÉTODO A TESTEAR
		List<Heroe> heroes = heroeService.findByName(nombreHeroe);		
		
		// COMPROBACIONES DEL RESULTADO ESPERADO
		assertNotNull(heroes);
		assertEquals(nombreHeroe, heroes.get(0).getNombre());
		assertThat(heroes).size().isEqualByComparingTo(1);
		assertNotEquals(valorIncorrecto, heroes.get(0).getNombre());
	}
	
	@Test
	@DisplayName("Test para buscar todos los heroe")
	void test_buscarTodosHeroes() throws Exception {
		
		// DEFINICIÓN DE VARIABLES DE ENTRADA Y RESULTADOS
		String nombreHeroe="superman";
		Iterable<Heroe> valorEsperado = List.of(new Heroe(Integer.valueOf(1),"superman", new Universo(1,"dc","Ce"), true));
		String valorIncorrecto = "medusa";
		
		// COMPORTAMIENTO ESPERADO DEL CUERPO DEL MÉTODO
		// BDDMockito.given(repository.buscarPelicula(id)).willReturn(valorEsperado);
		// Mockito.when(repository.buscarPelicula(anyInt())).thenReturn((any(Pelicula.class)));
		// Mockito.when(repository.buscarPelicula(any(Integer.class))).thenReturn(any());
		
		when(heroeService.findAll()).thenReturn(valorEsperado);
		
		
		// LLAMADA A MÉTODO A TESTEAR
		Iterable<Heroe> heroes = heroeService.findAll();		
		
		// COMPROBACIONES DEL RESULTADO ESPERADO
		assertNotNull(heroes);
		assertEquals(nombreHeroe, heroes.iterator().next().getNombre());
		assertNotEquals(valorIncorrecto, heroes.iterator().next().getNombre());
	}
	

	

}
