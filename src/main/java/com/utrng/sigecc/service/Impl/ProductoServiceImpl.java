package com.utrng.sigecc.service.Impl;

import com.utrng.sigecc.model.Producto;
import com.utrng.sigecc.repository.ProductoDAO;
import com.utrng.sigecc.service.ProductoService;
import com.utrng.sigecc.util.ProductoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductoServiceImpl implements ProductoService {
    @Autowired
    private ProductoDAO productoDAO;
    @Override
    public ProductoDTO guardarProducto(ProductoDTO productoDTO) {
        Producto producto = new Producto();
        producto.setNombre(productoDTO.getNombre());
        producto.setDescripcion(productoDTO.getDescripcion());
        producto.setCategoria(productoDTO.getCategoria());
        producto.setTalla(productoDTO.getTalla());
        producto.setColor(productoDTO.getColor());
        producto.setPrecio(productoDTO.getPrecio());
        producto.setStock(productoDTO.getStock());
        producto.setFechaCreacion(productoDTO.getFechaCreacion());

        Producto productoGuardado = productoDAO.save(producto);

        ProductoDTO respuesta = new ProductoDTO();
        respuesta.setIdProducto(productoGuardado.getIdProducto());
        respuesta.setNombre(productoGuardado.getNombre());
        respuesta.setDescripcion(productoGuardado.getDescripcion());
        respuesta.setCategoria(productoGuardado.getCategoria());
        respuesta.setTalla(productoGuardado.getTalla());
        respuesta.setColor(productoGuardado.getColor());
        respuesta.setPrecio(productoGuardado.getPrecio());
        respuesta.setStock(productoGuardado.getStock());
        respuesta.setFechaCreacion(productoGuardado.getFechaCreacion());
        return respuesta;
    }

    @Override
    public List<ProductoDTO> listarProductos() {
        List<Producto> productos = productoDAO.findAll();
        List<ProductoDTO> listaDTO = new ArrayList<>();

        for (Producto p : productos) {
            ProductoDTO dto = new ProductoDTO();
            dto.setIdProducto(p.getIdProducto());
            dto.setNombre(p.getNombre());
            dto.setDescripcion(p.getDescripcion());
            dto.setCategoria(p.getCategoria());
            dto.setTalla(p.getTalla());
            dto.setColor(p.getColor());
            dto.setPrecio(p.getPrecio());
            dto.setStock(p.getStock());
            dto.setFechaCreacion(p.getFechaCreacion());

            listaDTO.add(dto);
        }

        return listaDTO;
    }
}
