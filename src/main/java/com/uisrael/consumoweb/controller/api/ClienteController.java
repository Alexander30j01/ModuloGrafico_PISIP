package com.uisrael.consumoweb.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.uisrael.consumoweb.model.dto.response.ClienteResponseDto;
import com.uisrael.consumoweb.model.dto.response.DocumentacionResponseDto;
import com.uisrael.consumoweb.services.IClienteService;
import com.uisrael.consumoweb.services.IDocumentacionService;

@Controller
@RequestMapping("/api/clientes")
public class ClienteController {

	private final IClienteService servicioCliente;
	private final IDocumentacionService documentacionService;

	public ClienteController(IClienteService servicioCliente, IDocumentacionService documentacionService) {
		this.servicioCliente = servicioCliente;
		this.documentacionService = documentacionService;
	}

	@PostMapping("/registrar")
	public String registrarClienteBase(@ModelAttribute("clienteDto") ClienteResponseDto cliente) {
		try {
			servicioCliente.registrar(cliente);
		} catch (Exception e) {
			System.out.println("Error en API al registrar cliente: " + e.getMessage());
		}
		return "redirect:/vendedor/productos";
	}

	@PostMapping("/adjuntar-documento")
	public String adjuntarDocumento(@ModelAttribute("documentoDto") DocumentacionResponseDto documento) {
		try {
			documentacionService.guardar(documento);
		} catch (Exception e) {
			System.out.println("Error al guardar documentación: " + e.getMessage());
		}
		return "redirect:/vendedor/inicio";
	}
}