package com.uisrael.consumoweb.model.dto.request;

import lombok.Data;

@Data
public class PermisoRequestDto {
	private int idPermiso;

	private String nombre;

	private String descripcion;

	private boolean estado;

}
