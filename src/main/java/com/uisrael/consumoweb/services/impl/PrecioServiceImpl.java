package com.uisrael.consumoweb.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.PrecioResponseDto;
import com.uisrael.consumoweb.services.IPrecioSevice;

@Service
public class PrecioServiceImpl implements IPrecioSevice {

	private WebClient webClient;

	public PrecioServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public PrecioResponseDto guardar(PrecioResponseDto nuevoPrecio) {
		return this.webClient.post().uri("/precios/guardar").bodyValue(nuevoPrecio).retrieve()
				.bodyToMono(PrecioResponseDto.class).block();
	}

	@Override
	public Optional<PrecioResponseDto> buscarPorId(int idPrecio) {
		PrecioResponseDto dto = this.webClient.get().uri("/precios/" + idPrecio).retrieve()
				.bodyToMono(PrecioResponseDto.class).block();
		return Optional.ofNullable(dto);
	}

	@Override
	public List<PrecioResponseDto> listarTodo() {
		return this.webClient.get().uri("/precios/listar").retrieve().bodyToFlux(PrecioResponseDto.class).collectList()
				.block();
	}

	@Override
	public void eliminar(int idPrecio) {
		this.webClient.delete().uri("/precios/eliminar/" + idPrecio).retrieve().toBodilessEntity().block();
	}

}
