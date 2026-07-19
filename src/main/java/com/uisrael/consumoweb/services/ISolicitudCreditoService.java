package com.uisrael.consumoweb.services;

import java.util.List;
import java.util.Optional;

import com.uisrael.consumoweb.model.dto.response.SolicitudCreditoResponseDto;

public interface ISolicitudCreditoService {
	SolicitudCreditoResponseDto guardar(SolicitudCreditoResponseDto nuevoSolicitudCredito);

	Optional<SolicitudCreditoResponseDto> buscarPorId(int idSolicitudCredito);

	List<SolicitudCreditoResponseDto> listarTodo();

	void eliminar(int idSolicitudCredito);

	SolicitudCreditoResponseDto registrar(SolicitudCreditoResponseDto solicitudCredito);

	SolicitudCreditoResponseDto aprobar(int idSolicitudCredito);

	SolicitudCreditoResponseDto rechazar(int idSolicitudCredito);

}
