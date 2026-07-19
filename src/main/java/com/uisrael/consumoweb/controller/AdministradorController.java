package com.uisrael.consumoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/admin")
public class AdministradorController {
	
	@GetMapping({ "" , "/", "/inicio" })
	public String inicioAdmin() {
		// Apunta a templates/administrador/inicioadmin.html
		return "administrador/inicioadmin";
	}
	
	@GetMapping("/creditos")
	public String creditosAdmin() {
		// Apunta a templates/administrador/creditosadmin.html
		return "administrador/creditosadmin";
	}
	@GetMapping("/productos")
	public String productosAdmin() {
		// Apunta a templates/administrador/productosadmin.html
		return "administrador/productosadmin";
	}
	
	@GetMapping("/provincias")
	public String provinciasAdmin() {
		// Apunta a templates/administrador/provinciasadmin.html
		return "administrador/provinciasadmin";
	}
	@GetMapping("/usuarios")
	public String usuariosAdmin() {
		// Apunta a templates/administrador/usuariosadmin.html
		return "administrador/usuariosadmin";
	}
}
