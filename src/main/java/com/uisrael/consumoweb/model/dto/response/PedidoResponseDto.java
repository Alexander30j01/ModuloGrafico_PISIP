package com.uisrael.consumoweb.model.dto.response;

import lombok.Data;

@Data
public class PedidoResponseDto {


    private int idPedido;

    private String numeroPedido;

    private String cliente;

    private String vendedor;

    private String provincia;

    private int total;

    private String estado;

    private String observacion;


}