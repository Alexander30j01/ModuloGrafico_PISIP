package com.uisrael.consumoweb.services;

import java.util.List;
import java.util.Optional;

import com.uisrael.consumoweb.model.dto.response.VisitaResponseDto;

public interface IVisitaService {

	VisitaResponseDto guardar(VisitaResponseDto nuevaVisita);

	Optional<VisitaResponseDto> buscarPorId(int idVisita);

	List<VisitaResponseDto> listarTodo();

	void eliminar(int idVisita);

	VisitaResponseDto registrarIngreso(int idVisita);

	VisitaResponseDto registrarSalida(int idVisita);

	VisitaResponseDto registrarUbicacion(int idVisita, double latitud, double longitud);

	long calcularTiempoVisita(int idVisita);

	VisitaResponseDto agregarObservacion(int idVisita, String observacion);
}
