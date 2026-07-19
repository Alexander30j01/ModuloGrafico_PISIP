package com.uisrael.consumoweb.model.dto.request;

import java.time.Instant;

import lombok.Data;

@Data
public class VisitaRequestDto {
     
    private int idVisita;
    
    private Instant ingreso;
    
    private Instant salida;
    
    private double latitud;
    
    private double longitud;
    
    private String observacion;
    
    private boolean estado;

}
