package com.uisrael.consumoweb.services;

import java.util.List;
import java.util.Optional;

import com.uisrael.consumoweb.model.dto.response.ProductoResponseDto;

public interface IProductoService {
	
	ProductoResponseDto guardar(ProductoResponseDto nuevoProducto);

	Optional<ProductoResponseDto> buscarPorId(int idProducto);

	List<ProductoResponseDto> listarTodo();

	void eliminar(int idProducto);

	void actualizar(ProductoResponseDto producto);

}
