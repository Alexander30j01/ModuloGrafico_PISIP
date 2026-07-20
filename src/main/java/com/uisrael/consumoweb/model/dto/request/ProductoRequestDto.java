package com.uisrael.consumoweb.model.dto.request;

import lombok.Data;

@Data
public class ProductoRequestDto {
	
	private int idProductos;
	
	private String nombreProductos;
	
	private String descripcion;
	
	private int stock;
	
	private boolean estado;

}
