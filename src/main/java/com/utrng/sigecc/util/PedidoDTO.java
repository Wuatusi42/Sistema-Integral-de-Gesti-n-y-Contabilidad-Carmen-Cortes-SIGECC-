package com.utrng.sigecc.util;

import java.math.BigDecimal;
import java.util.List;

public class PedidoDTO {

    private String statusPedido;
    private Integer fkCliente;

    // Lista de productos que forman el pedido
    private List<DetallePedidoDTO> detalles;

    public String getStatusPedido() { return statusPedido; }
    public void setStatusPedido(String statusPedido) { this.statusPedido = statusPedido; }

    public Integer getFkCliente() { return fkCliente; }
    public void setFkCliente(Integer fkCliente) { this.fkCliente = fkCliente; }

    public List<DetallePedidoDTO> getDetalles() { return detalles; }
    public void setDetalles(List<DetallePedidoDTO> detalles) { this.detalles = detalles; }
}