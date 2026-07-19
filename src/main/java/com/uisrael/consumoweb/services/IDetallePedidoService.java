package com.uisrael.consumoweb.services;

import java.util.List;
import java.util.Optional;

import com.uisrael.consumoweb.model.dto.response.DetallePedidoResponseDto;

public interface IDetallePedidoService {
	DetallePedidoResponseDto guardar(DetallePedidoResponseDto detallePedido);

	Optional<DetallePedidoResponseDto> buscarPorId(int idDetallePedido);

	List<DetallePedidoResponseDto> listarTodos();

	void cambiarEstado(DetallePedidoResponseDto detallePedido, boolean aprobado);

}
