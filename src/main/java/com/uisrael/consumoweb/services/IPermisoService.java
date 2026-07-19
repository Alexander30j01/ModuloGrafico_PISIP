package com.uisrael.consumoweb.services;

import java.util.Optional;

import com.uisrael.consumoweb.model.dto.response.PermisoResponseDto;

public interface IPermisoService {
	
	Optional<PermisoResponseDto> obtenerPorId(int idPermiso);

	PermisoResponseDto guardar(PermisoResponseDto permiso);

}
