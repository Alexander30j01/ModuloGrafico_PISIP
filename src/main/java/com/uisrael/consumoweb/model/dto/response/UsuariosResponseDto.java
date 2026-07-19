package com.uisrael.consumoweb.model.dto.response;

import lombok.Data;

@Data
public class UsuariosResponseDto {

    private int idUsuario;
    private String nombre;
    private String apellido;
    private String rol;
    private String correoUsuario;
    private String region;
    private boolean activo;
    private boolean sesionActiva;
    private int numeroVisitas;

}