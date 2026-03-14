package com.utrng.sigecc.service;

import com.utrng.sigecc.model.Pedido;
import com.utrng.sigecc.util.PedidoDTO;

import java.util.List;

public interface PedidoService {
    List<Pedido> obtenerTodos();
    void guardar(PedidoDTO dto);
}