package com.utrng.sigecc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class DashboardController {

    @GetMapping("/")
    public String dashboard(Model model) {
        // Aquí después puedes agregar datos reales desde los services
        // model.addAttribute("totalProductos", productoService.contarProductos());
        // model.addAttribute("totalPedidos", pedidoService.contarPedidos());
        return "index"; // → src/main/resources/templates/index.html
    }
}