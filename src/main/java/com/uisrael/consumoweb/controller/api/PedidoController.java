package com.uisrael.consumoweb.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumoweb.model.dto.response.DetallePedidoResponseDto;
import com.uisrael.consumoweb.model.dto.response.PedidosResponseDto;
import com.uisrael.consumoweb.services.IDetallePedidoService;
import com.uisrael.consumoweb.services.IPedidosService;

@Controller
@RequestMapping("/api/pedidos")
public class PedidoController {

	private final IDetallePedidoService servicioDetallePedido;
	private final IPedidosService pedidosService;

	public PedidoController(IDetallePedidoService servicioDetallePedido, IPedidosService pedidosService) {
		this.servicioDetallePedido = servicioDetallePedido;
		this.pedidosService = pedidosService;
	}

	@PostMapping("/agregar-detalle")
	public String agregarDetalleAlCarrito(@ModelAttribute("detallePedidoDto") DetallePedidoResponseDto nuevoDetalle) {
		try {
			servicioDetallePedido.guardar(nuevoDetalle);
		} catch (Exception e) {
			System.out.println("Error al agregar ítem al carrito: " + e.getMessage());
		}
		return "redirect:/vendedor/productos";
	}

	@PostMapping("/guardar-final")
	public String procesarPedidoFinal(@ModelAttribute("pedidoDto") PedidosResponseDto pedidoMaestro) {
		try {
			pedidosService.guardar(pedidoMaestro);
		} catch (Exception e) {
			System.out.println("Error al procesar el cierre del pedido final: " + e.getMessage());
		}
		return "redirect:/vendedor/inicio";
	}

	@PostMapping("/aprobar/{id}")
	public String aprobarPedidoSupervisor(@PathVariable("id") int idDetalle,
			@ModelAttribute DetallePedidoResponseDto dto) {
		try {
			servicioDetallePedido.cambiarEstado(dto, true);
		} catch (Exception e) {
			System.out.println("Error supervisor al aprobar: " + e.getMessage());
		}
		return "redirect:/supervisor/pedidos";
	}

	@PostMapping("/rechazar/{id}")
	public String rechazarPedidoSupervisor(@PathVariable("id") int idDetalle,
			@ModelAttribute DetallePedidoResponseDto dto) {
		try {
			servicioDetallePedido.cambiarEstado(dto, false);
		} catch (Exception e) {
			System.out.println("Error supervisor al rechazar: " + e.getMessage());
		}
		return "redirect:/supervisor/pedidos";
	}

}
