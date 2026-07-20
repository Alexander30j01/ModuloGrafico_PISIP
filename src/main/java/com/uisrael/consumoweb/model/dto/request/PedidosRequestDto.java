package com.uisrael.consumoweb.model.dto.request;

import java.sql.Date;

import lombok.Data;

@Data
public class PedidosRequestDto {

	private int idPedidos;

	private Date fechaRegistro;
	
	private float subtotal;

	private float totalFinal;

	private String estadoPedido;

	private String metodoPago;

}
