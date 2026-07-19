package com.uisrael.consumoweb.model.dto.response;

import lombok.Data;

@Data
public class DetallePedidoResponseDto {
	private int idDetallePedidos;
	private int cantidad;
	private float precioUnitario;
	private float subTotal;
	private boolean estado;

	
}
