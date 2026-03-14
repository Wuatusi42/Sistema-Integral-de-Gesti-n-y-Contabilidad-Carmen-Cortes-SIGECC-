package com.utrng.sigecc.service.Impl;

import com.utrng.sigecc.model.CorteCaja;
import com.utrng.sigecc.model.Pedido;
import com.utrng.sigecc.repository.CorteCajaDAO;
import com.utrng.sigecc.repository.DetallePedidoDAO;
import com.utrng.sigecc.service.CorteCajaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class CorteCajaServiceImpl implements CorteCajaService {

    @Autowired
    private DetallePedidoDAO detallePedidoDAO;
    @Autowired
    private CorteCajaDAO corteCajaDAO;
    @Override
    public void guardarCorte(List<Pedido> pedidos) {

        BigDecimal totalGeneral = BigDecimal.ZERO;
        CorteCaja corteCaja = new CorteCaja();
        for (Pedido pedido : pedidos) {
            BigDecimal totalPedido = detallePedidoDAO.sumTotalByPedido(pedido);

            if (totalPedido == null) totalPedido = BigDecimal.ZERO;

            System.out.println("Pedido ID: " + pedido.getIdPedido() + " | Total: $" + totalPedido);

            totalGeneral = totalGeneral.add(totalPedido);
        }
        corteCaja.setStatusCorte("COMPLETADO");
        corteCaja.setTotalVentas(totalGeneral);
        corteCaja.setFechaGeneracion(LocalDateTime.now());
        corteCajaDAO.save(corteCaja);
        System.out.println("Total general del corte: $" + totalGeneral);
    }
}

