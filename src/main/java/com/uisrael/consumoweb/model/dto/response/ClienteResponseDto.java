package com.uisrael.consumoweb.model.dto.response;

import lombok.Data;

@Data
public class ClienteResponseDto {
	private int idCliente;
	private String ruc;
	private String telefono;
	private String nombreComercial;
	private String nombre;
	private String apellido;
	private String direccion;
	private String latitude;
	private String longitude;
	private boolean estado;

}
