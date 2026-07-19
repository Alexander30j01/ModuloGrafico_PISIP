package com.uisrael.consumoweb.services;

import java.util.List;

import com.uisrael.consumoweb.model.dto.response.CategoriaResponseDto;

public interface ICategoriaService {

	CategoriaResponseDto registrar(CategoriaResponseDto categoria);

	CategoriaResponseDto actualizar(CategoriaResponseDto categoria);

	void cambiarEstado(CategoriaResponseDto categoria, boolean activo);

	List<CategoriaResponseDto> listarTodo();

}
