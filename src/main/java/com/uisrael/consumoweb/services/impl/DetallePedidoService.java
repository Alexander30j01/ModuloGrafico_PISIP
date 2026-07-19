package com.uisrael.consumoweb.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.DetallePedidoResponseDto;
import com.uisrael.consumoweb.services.IDetallePedidoService;

public class DetallePedidoService implements IDetallePedidoService {

	private WebClient webClient;

	public DetallePedidoService(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public DetallePedidoResponseDto guardar(DetallePedidoResponseDto detallePedido) {
		return this.webClient.post().uri("/detalle-pedido/guardar").bodyValue(detallePedido).retrieve()
				.bodyToMono(DetallePedidoResponseDto.class).block();

	}

	@Override
	public Optional<DetallePedidoResponseDto> buscarPorId(int idDetallePedido) {
		DetallePedidoResponseDto dto = this.webClient.get().uri("/detalle-pedido/" + idDetallePedido).retrieve()
				.bodyToMono(DetallePedidoResponseDto.class).block();
		return Optional.ofNullable(dto);
	}

	@Override
	public List<DetallePedidoResponseDto> listarTodos() {
		return this.webClient.get().uri("/detalle-pedido/listar").retrieve().bodyToFlux(DetallePedidoResponseDto.class)
				.collectList().block();
	}

	@Override
	public void cambiarEstado(DetallePedidoResponseDto detallePedido, boolean aprobado) {
		this.webClient.patch().uri("/detalle-pedido/cambiar-estado/" + aprobado).bodyValue(detallePedido).retrieve()
				.toBodilessEntity().block();

	}

}
