package com.uisrael.consumoweb.controller.View;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;

import com.uisrael.consumoweb.model.dto.response.CategoriaResponseDto;
import com.uisrael.consumoweb.services.ICategoriaService;
import com.uisrael.consumoweb.services.IProductoService;
import com.uisrael.consumoweb.services.ISolicitudCreditoService;

@Controller
@RequestMapping("/administrador")
public class AdministradorController {

	private final ICategoriaService categoriaService;
	private final ISolicitudCreditoService solicitudCreditoService;
	private final IProductoService productoService;

	

	public AdministradorController(ICategoriaService categoriaService, ISolicitudCreditoService solicitudCreditoService,
			IProductoService productoService) {
		super();
		this.categoriaService = categoriaService;
		this.solicitudCreditoService = solicitudCreditoService;
		this.productoService = productoService;
	}

	@GetMapping({ "", "/", "/inicio" })
	public String inicioAdministrador() {
		return "administrador/inicioadministrador";
	}

	@GetMapping("/creditos")
	public String creditosAdministrador(Model model) {
		model.addAttribute("listaSolicitudes", solicitudCreditoService.listarTodo());
		return "administrador/creditosadministrador";
	}

	@GetMapping("/productos")
	public String productosAdministrador(Model model) {
		List<CategoriaResponseDto> resultadoBD = categoriaService.listarTodo();
		model.addAttribute("listaCategorias", resultadoBD);
		model.addAttribute("listaProductos", productoService.listarTodo());
		return "administrador/productosadministrador";
	}

	@GetMapping("/provincias")
	public String provinciasAdministrador() {
		return "administrador/provinciasadministrador";
	}

	@GetMapping("/usuarios")
	public String usuariosAdministrador() {
		return "administrador/usuariosadministrador";
	}
}
