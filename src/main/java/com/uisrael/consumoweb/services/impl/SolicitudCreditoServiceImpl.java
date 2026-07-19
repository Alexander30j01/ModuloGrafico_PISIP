package com.uisrael.consumoweb.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.SolicitudCreditoResponseDto;
import com.uisrael.consumoweb.services.ISolicitudCreditoService;

public class SolicitudCreditoServiceImpl implements ISolicitudCreditoService {
	
	private WebClient webClient;

	public SolicitudCreditoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public SolicitudCreditoResponseDto guardar(SolicitudCreditoResponseDto nuevoSolicitudCredito) {
		return this.webClient.post().uri("/solicitudes-credito/guardar").bodyValue(nuevoSolicitudCredito).retrieve()
				.bodyToMono(SolicitudCreditoResponseDto.class).block();
	}

	@Override
	public Optional<SolicitudCreditoResponseDto> buscarPorId(int idSolicitudCredito) {
		SolicitudCreditoResponseDto dto = this.webClient.get().uri("/solicitudes-credito" + idSolicitudCredito)
				.retrieve().bodyToMono(SolicitudCreditoResponseDto.class).block();
		return Optional.ofNullable(dto);
	}

	@Override
	public List<SolicitudCreditoResponseDto> listarTodo() {

		return this.webClient.get().uri("/solicitudes-credito/listar").retrieve()
				.bodyToFlux(SolicitudCreditoResponseDto.class).collectList().block();
	}

	@Override
	public void eliminar(int idSolicitudCredito) {
		this.webClient.delete().uri("/solicitudes-credito/eliminar/" + idSolicitudCredito).retrieve().toBodilessEntity()
				.block();
	}

	@Override
	public SolicitudCreditoResponseDto registrar(SolicitudCreditoResponseDto solicitudCredito) {
		return this.webClient.post().uri("/solicitudes-credito/registrar").bodyValue(solicitudCredito).retrieve()
				.bodyToMono(SolicitudCreditoResponseDto.class).block();
	}

	@Override
	public SolicitudCreditoResponseDto aprobar(int idSolicitudCredito) {
		return this.webClient.patch().uri("/solicitudes-credito/aprobar/" + idSolicitudCredito).retrieve()
				.bodyToMono(SolicitudCreditoResponseDto.class).block();
	}

	@Override
	public SolicitudCreditoResponseDto rechazar(int idSolicitudCredito) {
		return this.webClient.patch().uri("/solicitudes-credito/rechazar/" + idSolicitudCredito).retrieve()
				.bodyToMono(SolicitudCreditoResponseDto.class).block();
	}

}
