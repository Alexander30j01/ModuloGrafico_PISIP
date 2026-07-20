package com.uisrael.consumoweb.controller.View;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;


import com.uisrael.consumoweb.services.IPedidoService;
import com.uisrael.consumoweb.services.IVendedorService;
import com.uisrael.consumoweb.services.IReporteService;



@Controller
@RequestMapping("/supervisor")
public class SupervisorController {



    private final IPedidoService pedidoService;

    private final IVendedorService vendedorService;

    private final IReporteService reporteService;



    public SupervisorController(
            IPedidoService pedidoService,
            IVendedorService vendedorService,
            IReporteService reporteService) {


        this.pedidoService = pedidoService;
        this.vendedorService = vendedorService;
        this.reporteService = reporteService;

    }




    @GetMapping({"", "/", "/inicio"})
    public String inicioSupervisor(Model model) {


        model.addAttribute(
                "pedidos",
                pedidoService.listarPedidos()
        );


        model.addAttribute(
                "vendedores",
                vendedorService.listarVendedores()
        );


        model.addAttribute(
                "totalPedidos",
                pedidoService.listarPedidos().size()
        );


        model.addAttribute(
                "totalVendedores",
                vendedorService.listarVendedores().size()
        );


        // Datos temporales hasta conectar API real

        model.addAttribute(
                "ventasDia",
                28540
        );


        model.addAttribute(
                "clientesVisitados",
                52
        );


        return "supervisor/iniciosupervisor";

    }



    @GetMapping("/pedidos")
    public String pedidosSupervisor(Model model) {


        model.addAttribute(
                "pedidos",
                pedidoService.listarPedidos()
        );


        return "supervisor/pedidos";

    }



    @GetMapping("/monitoreo")
    public String monitoreoSupervisor(Model model) {


        model.addAttribute(
                "vendedores",
                vendedorService.listarVendedores()
        );


        return "supervisor/monitoreo";

    }




    @GetMapping("/reportes")
    public String reportesSupervisor(Model model) {


        model.addAttribute(
                "reporte",
                reporteService.generarReporte()
        );


        return "supervisor/reportes";

    }



    @PostMapping("/aprobar")
    public String aprobarPedido(
            @RequestParam("idPedido") int idPedido,
            RedirectAttributes flash) {



        pedidoService.aprobarPedido(idPedido);



        flash.addFlashAttribute(
                "mensaje",
                "Pedido aprobado correctamente"
        );


        return "redirect:/supervisor/pedidos";

    }





    @PostMapping("/rechazar")
    public String rechazarPedido(
            @RequestParam("idPedido") int idPedido,
            RedirectAttributes flash) {



        pedidoService.rechazarPedido(
                idPedido,
                "Rechazado por supervisor"
        );



        flash.addFlashAttribute(
                "mensaje",
                "Pedido rechazado correctamente"
        );


        return "redirect:/supervisor/pedidos";

    }





    @PostMapping("/guardarObservacion")
    public String guardarObservacion(
            RedirectAttributes flash) {



        flash.addFlashAttribute(
                "mensaje",
                "Observación guardada correctamente"
        );


        return "redirect:/supervisor/pedidos";

    }

    @PostMapping("/actualizarUbicacion")
    public String actualizarUbicacion(
            @RequestParam("idVendedor") int idVendedor,
            RedirectAttributes flash) {



        vendedorService.actualizarUbicacion(
                idVendedor,
                "Ubicación actualizada"
        );


        flash.addFlashAttribute(
                "mensaje",
                "Ubicación actualizada correctamente"
        );


        return "redirect:/supervisor/monitoreo";

    }





    @PostMapping("/contactarVendedor")
    public String contactarVendedor(
            RedirectAttributes flash) {


        flash.addFlashAttribute(
                "mensaje",
                "Mensaje enviado al vendedor"
        );


        return "redirect:/supervisor/monitoreo";

    }


    @PostMapping("/generarReporte")
    public String generarReporte(
            RedirectAttributes flash) {


        reporteService.generarReporte();


        flash.addFlashAttribute(
                "mensaje",
                "Reporte generado correctamente"
        );


        return "redirect:/supervisor/reportes";

    }





    @PostMapping("/exportarExcel")
    public String exportarExcel(
            RedirectAttributes flash) {


        flash.addFlashAttribute(
                "mensaje",
                "Reporte Excel preparado correctamente"
        );


        return "redirect:/supervisor/reportes";

    }

    @PostMapping("/exportarPdf")
    public String exportarPdf(
            RedirectAttributes flash) {


        flash.addFlashAttribute(
                "mensaje",
                "Reporte PDF preparado correctamente"
        );


        return "redirect:/supervisor/reportes";

    }



}