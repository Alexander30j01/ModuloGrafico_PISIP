package com.uisrael.consumoweb.model.dto.response;

import java.time.Instant;

import lombok.Data;

@Data
public class VisitaResponseDto {

    private int idVisita;

    private Instant ingreso;

    private Instant salida;

    private double latitud;

    private double longitud;

    private String observacion;

    private boolean estado;

}
