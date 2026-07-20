package com.uisrael.consumoweb.services;

import java.util.List;
import java.util.Optional;

import com.uisrael.consumoweb.model.dto.response.PrecioResponseDto;

public interface IPrecioSevice {
	
	PrecioResponseDto guardar(PrecioResponseDto nuevoPrecio);

	Optional<PrecioResponseDto> buscarPorId(int idPrecio);

	List<PrecioResponseDto> listarTodo();

	void eliminar(int idPrecio);

}
