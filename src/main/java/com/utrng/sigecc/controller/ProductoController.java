package com.utrng.sigecc.controller;

import com.utrng.sigecc.model.Producto;
import com.utrng.sigecc.service.ProductoService;
import com.utrng.sigecc.util.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Controller
public class ProductoController {
    @Autowired
    private ProductoService productoService;

    @GetMapping("/productos")
    public String dashboard(Model model) {
        model.addAttribute("productoDTO", new ProductoDTO());
        List<ProductoDTO> listaProductos = productoService.listarProductos();
        model.addAttribute("productos", listaProductos);

        return "productos"; // → src/main/resources/templates/index.html
    }

    @PostMapping("/saveProduct")
    public String saveProduct(Model model, ProductoDTO productoDTO){
        productoService.guardarProducto(productoDTO);
        return "redirect:/productos";
    }
}
