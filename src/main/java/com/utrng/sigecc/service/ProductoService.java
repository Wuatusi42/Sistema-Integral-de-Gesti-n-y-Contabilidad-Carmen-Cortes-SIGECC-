package com.utrng.sigecc.service;

import com.utrng.sigecc.model.Producto;
import com.utrng.sigecc.util.ProductoDTO;

import java.util.List;

public interface ProductoService {

    public ProductoDTO guardarProducto(ProductoDTO producto);

    public List<ProductoDTO> listarProductos();
}
