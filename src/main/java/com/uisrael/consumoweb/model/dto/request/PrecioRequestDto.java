package com.uisrael.consumoweb.model.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class PrecioRequestDto {
	
	private int idPrecio;
	
	private float precioVenta;
	
	private Date fechaInicio;
	
	private Date fechaFin;
	
	private boolean estadoPrecios;

}
