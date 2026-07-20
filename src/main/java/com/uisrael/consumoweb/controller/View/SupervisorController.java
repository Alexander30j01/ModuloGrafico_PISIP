package com.uisrael.consumoweb.controller.View;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumoweb.services.IDetallePedidoService;
import com.uisrael.consumoweb.services.IVisitaService;

@Controller
@RequestMapping("/supervisor")
public class SupervisorController {
	private final IDetallePedidoService detallePedidoService;
	private final IVisitaService visitaService;

	public SupervisorController(IDetallePedidoService detallePedidoService, IVisitaService visitaService) {
		this.detallePedidoService = detallePedidoService;
		this.visitaService = visitaService;
	}

	@GetMapping({ "", "/", "/inicio" })
	public String inicioSupervisor() {
		return "supervisor/iniciosupervisor";
	}

	@GetMapping("/pedidos")
	public String revisarPedidos(Model model) {
		model.addAttribute("listaPedidosPendientes", detallePedidoService.listarTodos());
		return "supervisor/pedidosrep";
	}

	@GetMapping("/visitas")
	public String verMapaYVisitas(Model model) {
		model.addAttribute("listaVisitas", visitaService.listarTodo());
		return "supervisor/visitasrep";
	}

}
