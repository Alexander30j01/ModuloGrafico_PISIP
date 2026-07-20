package com.uisrael.consumoweb.model.dto.response;


import lombok.Data;


@Data
public class ReporteResponseDto {



    private String tipoReporte;


    private String periodo;


    private double totalVentas;


    private int pedidosProcesados;


    private int clientesActivos;


    private double porcentajeMeta;



}