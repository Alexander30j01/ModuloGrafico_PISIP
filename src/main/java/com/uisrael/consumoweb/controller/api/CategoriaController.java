package com.uisrael.consumoweb.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumoweb.model.dto.response.CategoriaResponseDto;
import com.uisrael.consumoweb.services.ICategoriaService;

@Controller
@RequestMapping("/api/categorias")
public class CategoriaController {

	private final ICategoriaService categoriaService;

	public CategoriaController(ICategoriaService categoriaService) {
		this.categoriaService = categoriaService;
	}

	@PostMapping("/guardar")
	public String guardarCategoria(@ModelAttribute("categoriaDto") CategoriaResponseDto categoria) {
		try {
			categoriaService.registrar(categoria);
		} catch (Exception e) {
			System.out.println("Error al guardar categoría: " + e.getMessage());
		}
		return "redirect:/administrador/productos";
	}

}
