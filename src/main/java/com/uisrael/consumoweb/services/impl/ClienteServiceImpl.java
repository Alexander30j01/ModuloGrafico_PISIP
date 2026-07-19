package com.uisrael.consumoweb.services.impl;

import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.ClienteResponseDto;
import com.uisrael.consumoweb.services.IClienteService;

public class ClienteServiceImpl implements IClienteService {

	private WebClient webClient;

	public ClienteServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public ClienteResponseDto registrar(ClienteResponseDto cliente) {
		return this.webClient.post().uri("/clientes/registrar").bodyValue(cliente).retrieve()
				.bodyToMono(ClienteResponseDto.class).block();
	}

	@Override
	public ClienteResponseDto actualizar(ClienteResponseDto cliente) {
		return this.webClient.post().uri("/clientes/registrar").bodyValue(cliente).retrieve()
				.bodyToMono(ClienteResponseDto.class).block();
	}

	@Override
	public boolean solicitarCredito(int idCliente, double monto) {
		return Boolean.TRUE.equals(this.webClient
				.post().uri(uriBuilder -> uriBuilder.path("/clientes/solicitar-credito")
						.queryParam("idCliente", idCliente).queryParam("monto", monto).build())
				.retrieve().bodyToMono(Boolean.class).block());
	}

	@Override
	public boolean tieneCreditoAprobado(int idCliente) {
		return Boolean.TRUE.equals(this.webClient.get().uri("/clientes/credito-aprobado/" + idCliente).retrieve()
				.bodyToMono(Boolean.class).block());
	}

	@Override
	public void cambiarEstado(ClienteResponseDto cliente, boolean activo) {
		this.webClient.patch().uri("/clientes/cambiar-estado/" + activo).bodyValue(cliente)
		.retrieve().toBodilessEntity().block();
	}
	
	

}
