package com.uisrael.consumoweb.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.consumoweb.services.IVisitaService;

@Controller
@RequestMapping("/api/visitas")
public class VisitaController {

	private final IVisitaService visitaService;

	public VisitaController(IVisitaService visitaService) {
		this.visitaService = visitaService;
	}

	@PostMapping("/ingreso")
	public String marcarIngreso(@RequestParam("idVisita") int idVisita) {
		try {
			visitaService.registrarIngreso(idVisita);
		} catch (Exception e) {
			System.out.println("Error registrando ingreso: " + e.getMessage());
		}
		return "redirect:/vendedor/atender";
	}

	@PostMapping("/salida")
	public String marcarSalida(@RequestParam("idVisita") int idVisita,
			@RequestParam("observacion") String observacion) {
		try {
			visitaService.registrarSalida(idVisita);
			visitaService.agregarObservacion(idVisita, observacion);
		} catch (Exception e) {
			System.out.println("Error registrando salida: " + e.getMessage());
		}
		return "redirect:/vendedor/inicio";
	}

	@PostMapping("/gps")
	public String capturarUbicacion(@RequestParam("idVisita") int idVisita, @RequestParam("latitud") double latitud,
			@RequestParam("longitud") double longitud) {
		try {
			visitaService.registrarUbicacion(idVisita, latitud, longitud);
		} catch (Exception e) {
			System.out.println("Error al registrar coordenadas GPS: " + e.getMessage());
		}
		return "redirect:/vendedor/atender";
	}

}
