package com.uisrael.consumoweb.services.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.ProductoResponseDto;
import com.uisrael.consumoweb.services.IProductoService;
@Service
public class ProductoServiceImpl implements IProductoService {

	private WebClient webClient;

	public ProductoServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public ProductoResponseDto guardar(ProductoResponseDto nuevoProducto) {
		return this.webClient.post().uri("/productos/guardar").bodyValue(nuevoProducto).retrieve()
				.bodyToMono(ProductoResponseDto.class).block();
	}

	@Override
	public Optional<ProductoResponseDto> buscarPorId(int idProducto) {
		ProductoResponseDto dto = this.webClient.get().uri("/productos/" + idProducto).retrieve()
				.bodyToMono(ProductoResponseDto.class).block();
		return Optional.ofNullable(dto);
	}

	@Override
	public List<ProductoResponseDto> listarTodo() {
		return this.webClient.get().uri("/productos/listar").retrieve().bodyToFlux(ProductoResponseDto.class)
				.collectList().block();
	}

	@Override
	public void eliminar(int idProducto) {
		this.webClient.delete().uri("/productos/eliminar/" + idProducto).retrieve().toBodilessEntity().block();
	}

	@Override
	public void actualizar(ProductoResponseDto producto) {
		this.webClient.put().uri("/productos/actualizar/" + producto.getIdProductos()).bodyValue(producto).retrieve()
				.toBodilessEntity().block();
	}

}
