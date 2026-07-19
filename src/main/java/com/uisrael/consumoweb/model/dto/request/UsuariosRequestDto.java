package com.uisrael.consumoweb.model.dto.request;

import lombok.Data;

@Data
public class UsuariosRequestDto {

	private int idUsuario;

	private String nombre;

	private String apellido;

	private String rol;

	private String correoUsuario;

	private String contrasena;

	private String region;

	private boolean activo;

	private boolean sesionActiva;

	private int numeroVisitas;

}