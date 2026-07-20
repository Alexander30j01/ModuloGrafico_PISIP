package com.uisrael.consumoweb.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.uisrael.consumoweb.services.IClienteService;
import com.uisrael.consumoweb.services.ISolicitudCreditoService;

@Controller
@RequestMapping("/api/creditos")
public class CreditoController {

	private final ISolicitudCreditoService solicitudCreditoService;
	private final IClienteService servicioCliente;

	public CreditoController(ISolicitudCreditoService solicitudCreditoService, IClienteService servicioCliente) {
		this.solicitudCreditoService = solicitudCreditoService;
		this.servicioCliente = servicioCliente;
	}

	@PostMapping("/solicitar")
	public String procesarCreditoYContinuar(@RequestParam("idCliente") int idCliente,
			@RequestParam("monto") double monto) {
		try {
			servicioCliente.solicitarCredito(idCliente, monto);
		} catch (Exception e) {
			System.out.println("Error en API al solicitar crédito: " + e.getMessage());
		}
		return "redirect:/vendedor/productos";
	}

	@PostMapping("/aprobar/{id}")
	public String aprobarCredito(@PathVariable("id") int idSolicitudCredito) {
		try {
			solicitudCreditoService.aprobar(idSolicitudCredito);
		} catch (Exception e) {
			System.out.println("Error al aprobar solicitud: " + e.getMessage());
		}
		return "redirect:/administrador/creditos";
	}

	@PostMapping("/rechazar/{id}")
	public String rechazarCredito(@PathVariable("id") int idSolicitudCredito) {
		try {
			solicitudCreditoService.rechazar(idSolicitudCredito);
		} catch (Exception e) {
			System.out.println("Error al rechazar solicitud: " + e.getMessage());
		}
		return "redirect:/administrador/creditos";
	}
}