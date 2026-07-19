package com.uisrael.consumoweb.controller.View;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.uisrael.consumoweb.model.dto.response.ClienteResponseDto;
import com.uisrael.consumoweb.model.dto.response.DetallePedidoResponseDto;
import com.uisrael.consumoweb.services.IClienteService;
import com.uisrael.consumoweb.services.IDetallePedidoService;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {

	private IClienteService servicioCliente;
	private IDetallePedidoService servicioDetallePedido;

	public VendedorController(IClienteService servicioCliente, IDetallePedidoService servicioDetallePedido) {
		this.servicioCliente = servicioCliente;
		this.servicioDetallePedido = servicioDetallePedido;
	}

	public VendedorController(IClienteService servicioCliente) {
		this.servicioCliente = servicioCliente;
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
	public String irSolicitudCredito(@RequestParam(value = "idCliente", defaultValue = "1") int idCliente,
			Model model) {
		boolean tieneCredito = servicioCliente.tieneCreditoAprobado(idCliente);
		model.addAttribute("tieneCreditoAprobado", tieneCredito);
		model.addAttribute("idCliente", idCliente);

		return "vendedor/solicitudcredito";
	}

	@GetMapping("/productos")
	public String irCatalogo(Model model) {
		return "vendedor/productos";
	}

	@GetMapping("/carrito")
	public String irPedido(Model model) {
		model.addAttribute("detallesCarrito", servicioDetallePedido.listarTodos());
		return "vendedor/pedido";
	}

	@PostMapping("/atender/registrar-base")
	public String registrarClienteBase(@ModelAttribute("clienteDto") ClienteResponseDto cliente, Model model) {
		try {
			ClienteResponseDto clienteRegistrado = servicioCliente.registrar(cliente);
			System.out
					.println("Controller: Cliente registrado exitosamente con ID: " + clienteRegistrado.getIdCliente());
		} catch (Exception e) {
			System.out.println(" Error en Controller al registrar cliente: " + e.getMessage());
		}
		return "redirect:/vendedor/productos";
	}

	@PostMapping("/atender/registrar-credito")
	public String procesarCreditoYContinuar(@RequestParam("idCliente") int idCliente,
			@RequestParam("monto") double monto) {
		try {
			boolean solicitado = servicioCliente.solicitarCredito(idCliente, monto);
			System.out.println("Controller: ¿Solicitud de crédito enviada?: " + solicitado);
		} catch (Exception e) {
			System.out.println("Error en Controller al solicitar crédito: " + e.getMessage());
		}

		return "redirect:/vendedor/productos";
	}

	@PostMapping("/pedido/guardar-final")
	public String guardarPedidoFinal(@ModelAttribute("detallePedidoDto") DetallePedidoResponseDto nuevoDetalle) {
		try {
			DetallePedidoResponseDto detalleGuardado = servicioDetallePedido.guardar(nuevoDetalle);
			System.out.println("Controller: Detalle de pedido guardado en API. ID asignado: "
					+ detalleGuardado.getIdDetallePedidos());
		} catch (Exception e) {
			System.out.println("Error en Controller al guardar el detalle del pedido en la API: " + e.getMessage());
		}
		return "redirect:/vendedor/inicio";
	}

	@PostMapping("/pedido/guardar-final")
	public String guardarPedidoFinal() {
		System.out.println("Controller: Procesando el guardado final del carrito de compras...");
		return "redirect:/vendedor/inicio";
	}
}