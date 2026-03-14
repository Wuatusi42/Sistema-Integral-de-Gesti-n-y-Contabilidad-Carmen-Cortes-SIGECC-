package com.utrng.sigecc.util;

import java.math.BigDecimal;

public class DetallePedidoDTO {

    private Integer fkProducto;
    private Integer cantidad;
    private BigDecimal total;

    public Integer getFkProducto() { return fkProducto; }
    public void setFkProducto(Integer fkProducto) { this.fkProducto = fkProducto; }

    public Integer getCantidad() { return cantidad; }
    public void setCantidad(Integer cantidad) { this.cantidad = cantidad; }

    public BigDecimal getTotal() { return total; }
    public void setTotal(BigDecimal total) { this.total = total; }
}