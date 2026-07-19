package com.uisrael.consumoweb.services.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.CategoriaResponseDto;
import com.uisrael.consumoweb.services.ICategoriaService;

@Service
public class CategoriaServiceImpl implements ICategoriaService {

	private WebClient webClient;

	public CategoriaServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public CategoriaResponseDto registrar(CategoriaResponseDto categoria) {
		return webClient.post().uri("/categoria").bodyValue(categoria).retrieve().bodyToMono(CategoriaResponseDto.class)
				.block();
	}

	@Override
	public CategoriaResponseDto actualizar(CategoriaResponseDto categoria) {
		return webClient.put().uri("/categoria").bodyValue(categoria).retrieve().bodyToMono(CategoriaResponseDto.class)
				.block();
	}

	@Override
	public void cambiarEstado(CategoriaResponseDto categoria, boolean activo) {
		webClient.patch().uri("/categoria/cambiar-estado?activo=" + activo).bodyValue(categoria).retrieve()
				.bodyToMono(Void.class).block();
	}

	
	
	
	
	@Override
	public List<CategoriaResponseDto> listarTodo() {
		// 1. COMENTAMOS la línea del profe temporalmente para que no busque el backend apagado
		/*
		return webClient.get().uri("/categoria").retrieve().bodyToFlux(CategoriaResponseDto.class).collectList()
				.block();
		*/

		// 2. SIMULAMOS los datos que te daría la API para que puedas avanzar solo
		List<CategoriaResponseDto> listaSimulada = new ArrayList<>();
		
		// Categoría 1
		CategoriaResponseDto cat1 = new CategoriaResponseDto();
		cat1.setIdCategoria(1); // O el nombre que tenga el ID en tu DTO
		cat1.setNombre("Juguetes de Madera");
		cat1.setEstado(true);
		
		// Categoría 2
		CategoriaResponseDto cat2 = new CategoriaResponseDto();
		cat2.setIdCategoria(2);
		cat2.setNombre("Juguetes Electrónicos");
		cat2.setEstado(true);

		// Categoría 3
		CategoriaResponseDto cat3 = new CategoriaResponseDto();
		cat3.setIdCategoria(3);
		cat3.setNombre("Juegos de Mesa");
		cat3.setEstado(false);

		listaSimulada.add(cat1);
		listaSimulada.add(cat2);
		listaSimulada.add(cat3);

		return listaSimulada; // Devolvemos la lista de mentira
	}

}
