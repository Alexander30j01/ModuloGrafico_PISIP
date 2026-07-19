package com.uisrael.consumoweb.services;

import com.uisrael.consumoweb.model.dto.response.UsuariosResponseDto;

public interface IUsuariosService {

	UsuariosResponseDto iniciarSesion(int idUsuario);

	UsuariosResponseDto cerrarSesion(int idUsuario);

	UsuariosResponseDto actualizarPerfil(int idUsuario, UsuariosResponseDto usuario);

	UsuariosResponseDto cambiarContrasena(int idUsuario, String nuevaContrasena);

	UsuariosResponseDto asignarRol(int idUsuario, String rol);

	UsuariosResponseDto asignarRegion(int idUsuario, String region);

	UsuariosResponseDto activar(int idUsuario);

	UsuariosResponseDto desactivar(int idUsuario);

	UsuariosResponseDto generarReporteVisitas(int idUsuario);

}
