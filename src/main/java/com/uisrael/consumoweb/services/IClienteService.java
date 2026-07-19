package com.uisrael.consumoweb.services;

import com.uisrael.consumoweb.model.dto.response.ClienteResponseDto;

public interface IClienteService {

	ClienteResponseDto registrar(ClienteResponseDto cliente);

	ClienteResponseDto actualizar(ClienteResponseDto cliente);

	boolean solicitarCredito(int idCliente, double monto);

	boolean tieneCreditoAprobado(int idCliente);

	void cambiarEstado(ClienteResponseDto categoria, boolean activo);

}
