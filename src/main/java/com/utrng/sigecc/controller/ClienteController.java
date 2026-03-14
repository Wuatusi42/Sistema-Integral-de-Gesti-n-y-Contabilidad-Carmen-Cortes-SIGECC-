package com.utrng.sigecc.controller;

import com.utrng.sigecc.service.CLienteService;
import com.utrng.sigecc.util.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ClienteController {

    @Autowired
    private CLienteService clienteService;

    @GetMapping("/clientes")
    public String clientes(Model model) {
        model.addAttribute("clientes", clienteService.obtenerTodos());
        model.addAttribute("clienteDTO", new ClienteDTO());
        model.addAttribute("totalClientes", clienteService.obtenerTodos().size());
        return "clientes";
    }

    @PostMapping("/saveCliente")
    public String guardarCliente(@ModelAttribute ClienteDTO clienteDTO) {
        clienteService.guardar(clienteDTO);
        return "redirect:/clientes";
    }
}