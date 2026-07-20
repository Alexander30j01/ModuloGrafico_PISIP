package com.uisrael.consumoweb.services;

import java.util.Optional;

import com.uisrael.consumoweb.model.dto.response.PedidosResponseDto;

public interface IPedidosService {
	
	PedidosResponseDto guardar(PedidosResponseDto pedido);

	Optional<PedidosResponseDto> buscarPorId(int idPedido);

	void eliminar(int idPedido);

}
