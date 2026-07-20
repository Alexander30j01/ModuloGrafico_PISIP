package com.uisrael.consumoweb.model.dto.response;

import java.sql.Date;

import lombok.Data;

@Data
public class PedidosResponseDto {
	private int idPedidos;
	private Date fechaRegistro;
	private float subtotal;
	private float totalFinal;
	private String estadoPedido;
	private String metodoPago;
	

}
