package com.uisrael.consumoweb.services.impl;

import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.PedidosResponseDto;
import com.uisrael.consumoweb.services.IPedidosService;

@Service
public class PedidosServiceImpl implements IPedidosService {

	private WebClient webClient;

	public PedidosServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public PedidosResponseDto guardar(PedidosResponseDto pedido) {
		return this.webClient.post().uri("/pedidos/guardar").bodyValue(pedido).retrieve()
				.bodyToMono(PedidosResponseDto.class).block();
	}

	@Override
	public Optional<PedidosResponseDto> buscarPorId(int idPedido) {
		PedidosResponseDto dto = this.webClient.get().uri("/pedidos/" + idPedido).retrieve()
				.bodyToMono(PedidosResponseDto.class).block();
		return Optional.ofNullable(dto);
	}

	@Override
	public void eliminar(int idPedido) {
		this.webClient.delete().uri("/pedidos/eliminar/" + idPedido).retrieve().toBodilessEntity().block();
	}

}
