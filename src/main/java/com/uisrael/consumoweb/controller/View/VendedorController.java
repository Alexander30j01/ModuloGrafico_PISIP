package com.uisrael.consumoweb.controller.View;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.consumoweb.model.dto.response.ClienteResponseDto;
import com.uisrael.consumoweb.services.IClienteService;
import com.uisrael.consumoweb.services.IDetallePedidoService;
import com.uisrael.consumoweb.services.IProductoService;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {
	private final IClienteService servicioCliente;
	private final IDetallePedidoService servicioDetallePedido;
	private final IProductoService productoService;

	public VendedorController(IClienteService servicioCliente, IDetallePedidoService servicioDetallePedido,
			IProductoService productoService) {
		this.servicioCliente = servicioCliente;
		this.servicioDetallePedido = servicioDetallePedido;
		this.productoService = productoService;
	}

	@GetMapping({ "", "/", "/inicio" })
	public String leerpaginaInicio() {
		return "vendedor/inicio";
	}

	@GetMapping("/atender")
	public String irAtender() {
		return "vendedor/atender";
	}

	@GetMapping("/atender/nuevo")
	public String irNuevoCliente(Model model) {
		model.addAttribute("clienteDto", new ClienteResponseDto());
		return "vendedor/nuevoCliente";
	}

	@GetMapping("/atender/credito")
	public String irSolicitudCredito(@RequestParam(value =  "idCliente", defaultValue = "1") int idCliente,
			Model model) {
		boolean tieneCredito = servicioCliente.tieneCreditoAprobado(idCliente);
		model.addAttribute("tieneCreditoAprobado", tieneCredito);
		model.addAttribute("idCliente", idCliente);
		return "vendedor/solicitudcredito";
	}

	@GetMapping("/productos")
	public String irCatalogo(Model model) {
		model.addAttribute("catalogoProductos", productoService.listarTodo());
		return "vendedor/productos";
	}

	@GetMapping("/carrito")
	public String irPedido(Model model) {
		model.addAttribute("detallesCarrito", servicioDetallePedido.listarTodos());
		return "vendedor/pedido";
	}

}