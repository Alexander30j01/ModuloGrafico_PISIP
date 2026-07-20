package com.uisrael.consumoweb.controller.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.uisrael.consumoweb.model.dto.response.PrecioResponseDto;
import com.uisrael.consumoweb.model.dto.response.ProductoResponseDto;
import com.uisrael.consumoweb.services.IPrecioSevice;
import com.uisrael.consumoweb.services.IProductoService;

@Controller
@RequestMapping("/api/producto")
public class ProductoController {
	private final IProductoService productoService;
	private final IPrecioSevice precioService;

	public ProductoController(IProductoService productoService, IPrecioSevice precioService) {
		this.productoService = productoService;
		this.precioService = precioService;
	}

	@PostMapping("/guardar")
	public String guardarProducto(@ModelAttribute("productoDto") ProductoResponseDto producto) {
		try {
			productoService.guardar(producto);
		} catch (Exception e) {
			System.out.println("Error al guardar producto: " + e.getMessage());
		}
		return "redirect:/administrador/producto";
	}

	@PostMapping("/actualizar")
	public String actualizarProducto(@ModelAttribute("productoDto") ProductoResponseDto producto) {
		try {
			productoService.actualizar(producto);
		} catch (Exception e) {
			System.out.println("Error al actualizar producto: " + e.getMessage());
		}
		return "redirect:/administrador/producto";
	}

	@PostMapping("/eliminar/{id}")
	public String eliminarProducto(@PathVariable("id") int idProducto) {
		try {
			productoService.eliminar(idProducto);
		} catch (Exception e) {
			System.out.println("Error al eliminar producto: " + e.getMessage());
		}
		return "redirect:/administrador/producto";
	}

	@PostMapping("/precios/guardar")
	public String guardarPrecioProducto(@ModelAttribute("precioDto") PrecioResponseDto precio) {
		try {
			precioService.guardar(precio);
		} catch (Exception e) {
			System.out.println("Error al fijar precio: " + e.getMessage());
		}
		return "redirect:/administrador/producto";
	}

}
