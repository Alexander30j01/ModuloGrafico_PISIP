package com.uisrael.consumoweb.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.VisitaResponseDto;
import com.uisrael.consumoweb.services.IVisitaService;

public class VisitaServiceImpl implements IVisitaService {

	private WebClient webClient;

	public VisitaServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public VisitaResponseDto guardar(VisitaResponseDto nuevaVisita) {
		return this.webClient.post().uri("/visitas/guardar").bodyValue(nuevaVisita).retrieve()
				.bodyToMono(VisitaResponseDto.class).block();
	}

	@Override
	public Optional<VisitaResponseDto> buscarPorId(int idVisita) {
		VisitaResponseDto dto = this.webClient.get().uri("/visitas/" + idVisita).retrieve()
				.bodyToMono(VisitaResponseDto.class).block();
		return Optional.ofNullable(dto);
	}

	@Override
	public List<VisitaResponseDto> listarTodo() {
		return this.webClient.get().uri("/visitas/listar").retrieve().bodyToFlux(VisitaResponseDto.class).collectList()
				.block();

	}

	@Override
	public void eliminar(int idVisita) {
		this.webClient.delete().uri("/visitas/eliminar/" + idVisita).retrieve().toBodilessEntity().block();
	}

	@Override
	public VisitaResponseDto registrarIngreso(int idVisita) {
		return this.webClient.post().uri("/visitas/registrar-ingreso/" + idVisita).retrieve()
				.bodyToMono(VisitaResponseDto.class).block();
	}

	@Override
	public VisitaResponseDto registrarSalida(int idVisita) {
		return this.webClient.post().uri("/visitas/registrar-salida/" + idVisita).retrieve()
				.bodyToMono(VisitaResponseDto.class).block();
	}

	@Override
	public VisitaResponseDto registrarUbicacion(int idVisita, double latitud, double longitud) {
		return this.webClient.patch()
				.uri(uriBuilder -> uriBuilder.path("/visitas/registrar-ubicacion/" + idVisita)
						.queryParam("latitud", latitud).queryParam("longitud", longitud).build())
				.retrieve().bodyToMono(VisitaResponseDto.class).block();
	}

	@Override
	public long calcularTiempoVisita(int idVisita) {
		Long tiempo = this.webClient.get().uri("/visitas/calcular-tiempo/" + idVisita).retrieve().bodyToMono(Long.class)
				.block();
		return tiempo != null ? tiempo : 0L;
	}

	@Override
	public VisitaResponseDto agregarObservacion(int idVisita, String observacion) {
		return this.webClient.patch()
				.uri(uriBuilder -> uriBuilder.path("/visitas/agregar-observacion/" + idVisita)
						.queryParam("observacion", observacion).build())
				.retrieve().bodyToMono(VisitaResponseDto.class).block();
	}

}
