package com.utrng.sigecc.controller;

import com.utrng.sigecc.repository.ProductoDAO;
import com.utrng.sigecc.service.CLienteService;
import com.utrng.sigecc.service.PedidoService;
import com.utrng.sigecc.util.PedidoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class DashboardController {

    @Autowired
    private PedidoService pedidoService;

    @Autowired
    private CLienteService cLienteService;

    @Autowired
    private ProductoDAO productoRepository; // ← agregar

    @GetMapping("/")
    public String dashboard(Model model) {
        model.addAttribute("pedidos", pedidoService.obtenerTodos());
        model.addAttribute("pedidoDTO", new PedidoDTO());
        model.addAttribute("clientes", cLienteService.obtenerTodos());
        model.addAttribute("productos", productoRepository.findAll()); // ← agregar
        return "index";
    }

    @PostMapping("/savePedido")
    public String savePedido(@ModelAttribute PedidoDTO pedidoDTO) {
        pedidoService.guardar(pedidoDTO);
        return "redirect:/";
    }
}