package com.uisrael.consumoweb.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.uisrael.consumoweb.model.dto.response.CategoriaResponseDto;
import com.uisrael.consumoweb.services.ICategoriaService;

@Controller
@RequestMapping("/admin")
public class AdministradorController {

	private final ICategoriaService categoriaService;

	public AdministradorController(ICategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@GetMapping({ "", "/", "/inicio" })
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
	public String productosAdmin(Model model) {
		List<CategoriaResponseDto> resultadoBD = categoriaService.listarTodo();
		System.out.println(resultadoBD);
		model.addAttribute("listaCategorias", resultadoBD);
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
