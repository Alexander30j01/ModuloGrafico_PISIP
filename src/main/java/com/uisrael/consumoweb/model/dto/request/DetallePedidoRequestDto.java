package com.uisrael.consumoweb.model.dto.request;

import lombok.Data;

@Data
public class DetallePedidoRequestDto {
	
	private int idDetallePedidos;
	
	private int cantidad;
	
	private float precioUnitario;
	
	private float subTotal;
	
	private boolean estado;

}
