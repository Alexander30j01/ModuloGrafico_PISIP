package com.uisrael.consumoweb.model.dto.response;


import lombok.Data;


@Data
public class VendedorResponseDto {


    private int idVendedor;


    private String nombre;


    private String apellido;


    private String provincia;


    private int clientesAsignados;


    private double ventas;


    private double meta;


    private String estado;


    private String ubicacion;



}