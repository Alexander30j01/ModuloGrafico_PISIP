package com.uisrael.consumoweb.services.impl;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import com.uisrael.consumoweb.model.dto.response.UsuariosResponseDto;
import com.uisrael.consumoweb.services.IUsuariosService;


@Service
public class UsuariosServiceImpl implements IUsuariosService {

	private WebClient webClient;

	public UsuariosServiceImpl(WebClient webClient) {
		this.webClient = webClient;
	}

	@Override
	public UsuariosResponseDto iniciarSesion(int idUsuario) {
		return this.webClient.post().uri("/usuarios/iniciar-sesion" + idUsuario).retrieve()
				.bodyToMono(UsuariosResponseDto.class).block();
	}

	@Override
	public UsuariosResponseDto cerrarSesion(int idUsuario) {
		return this.webClient.post().uri("/usuarios/cerrar-sesion/" + idUsuario).retrieve()
				.bodyToMono(UsuariosResponseDto.class).block();
	}

	@Override
	public UsuariosResponseDto actualizarPerfil(int idUsuario, UsuariosResponseDto usuario) {
		return this.webClient.patch().uri("/usuarios/actualizar-perfil" + idUsuario).bodyValue(usuario).retrieve()
				.bodyToMono(UsuariosResponseDto.class).block();
	}

	@Override
	public UsuariosResponseDto cambiarContrasena(int idUsuario, String nuevaContrasena) {
		return this.webClient.patch()
				.uri(uriBuilder -> uriBuilder.path("/usuarios/cambiar-contrasena/" + idUsuario)
						.queryParam("nuevaContrasena", nuevaContrasena).build())
				.retrieve().bodyToMono(UsuariosResponseDto.class).block();
	}

	@Override
	public UsuariosResponseDto asignarRol(int idUsuario, String rol) {
		return this.webClient.patch()
				.uri(uriBuilder -> uriBuilder.path("/usuarios/asignar-rol/" + idUsuario).queryParam("rol", rol).build())
				.retrieve().bodyToMono(UsuariosResponseDto.class).block();
	}

	@Override
	public UsuariosResponseDto asignarRegion(int idUsuario, String region) {
		return this.webClient.patch().uri(uriBuilder -> uriBuilder.path("/usuarios/asignar-region/" + idUsuario)
				.queryParam("region", region).build()).retrieve().bodyToMono(UsuariosResponseDto.class).block();
	}

	@Override
	public UsuariosResponseDto activar(int idUsuario) {
		return this.webClient.patch().uri("/usuarios/activar/" + idUsuario).retrieve()
				.bodyToMono(UsuariosResponseDto.class).block();
	}

	@Override
	public UsuariosResponseDto desactivar(int idUsuario) {
		return this.webClient.patch().uri("/usuarios/desactivar/" + idUsuario).retrieve()
				.bodyToMono(UsuariosResponseDto.class).block();
	}

	@Override
	public UsuariosResponseDto generarReporteVisitas(int idUsuario) {
		return this.webClient.get().uri("/usuarios/reporte-visitas" + idUsuario).retrieve()
				.bodyToMono(UsuariosResponseDto.class).block();
	}

}
