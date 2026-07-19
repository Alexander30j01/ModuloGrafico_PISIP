package com.uisrael.consumoweb.services.impl;

import java.util.Optional;

import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.PermisoResponseDto;
import com.uisrael.consumoweb.services.IPermisoService;

public class PermisoServiceImpl implements IPermisoService{
	private WebClient webClient;

	public PermisoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public Optional<PermisoResponseDto> obtenerPorId(int idPermiso) {
PermisoResponseDto dto= this.webClient.get().uri("/perimiso" + idPermiso).retrieve()
.bodyToMono(PermisoResponseDto.class).block();
		return Optional.ofNullable(dto);
	}

	@Override
	public PermisoResponseDto guardar(PermisoResponseDto permiso) {
		return this.webClient.post().uri("/permiso/guardar").bodyValue(permiso)
				.retrieve().bodyToMono(PermisoResponseDto.class).block();
	}


}
