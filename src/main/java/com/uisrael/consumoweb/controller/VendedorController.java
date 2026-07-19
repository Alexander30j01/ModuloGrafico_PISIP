package com.uisrael.consumoweb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/vendedor")
public class VendedorController {
    
    // ==========================================
    // VISTAS (GET) - Muestran las páginas HTML
    // ==========================================

    @GetMapping({"", "/", "/inicio"})
    public String leerpaginaInicio() {
        return "vendedor/inicio"; 
    }

    @GetMapping("/atender")
    public String irAtender() {
        return "vendedor/atender";
    }

    @GetMapping("/atender/nuevo")
    public String irNuevoCliente() {
        return "vendedor/nuevoCliente";
    }

    @GetMapping("/atender/credito")
    public String irSolicitudCredito() {
        // CORREGIDO: Apunta exactamente a tu archivo solicitudcredito.html
        return "vendedor/solicitudcredito";
    }
    
    @GetMapping("/productos")
    public String irCatalogo(Model model) {
        return "vendedor/productos"; 
    }

    @GetMapping("/carrito")
    public String irPedido() {
        return "vendedor/pedido";
    }

    // ==========================================
    // PROCESOS (POST) - Reciben formularios y REDIRIGEN
    // ==========================================

    @PostMapping("/atender/registrar-base")
    public String registrarClienteBase() {
        return "redirect:/vendedor/productos";
    }

    @PostMapping("/atender/registrar-credito")
    public String procesarCreditoYContinuar() {
        return "redirect:/vendedor/productos";
    }

    @PostMapping("/pedido/guardar-final")
    public String guardarPedidoFinal() {
        return "redirect:/vendedor/inicio";
    }
}