package com.uisrael.consumoweb.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.DocumentacionResponseDto;
import com.uisrael.consumoweb.services.IDocumentacionService;

@Service
public class DocumentacionServiceImpl implements IDocumentacionService {

	private WebClient webClient;

	public DocumentacionServiceImpl(WebClient webClient) {
		super();
		this.webClient = webClient;
	}

	@Override
	public DocumentacionResponseDto guardar(DocumentacionResponseDto documento) {
		return this.webClient.post().uri("/documentacion/guardar").bodyValue(documento).retrieve()
				.bodyToMono(DocumentacionResponseDto.class).block();
	}

	@Override
	public void eliminar(int idDocumentacion) {
		this.webClient.delete().uri("/documentacion/eliminar/" + idDocumentacion).retrieve().toBodilessEntity().block();
	}

	@Override
	public Optional<DocumentacionResponseDto> obtenerPorId(int idDocumentacion) {
		DocumentacionResponseDto dto = this.webClient.get().uri("/documentacion/" + idDocumentacion).retrieve()
				.bodyToMono(DocumentacionResponseDto.class).block();
		return Optional.ofNullable(dto);
	}

}
