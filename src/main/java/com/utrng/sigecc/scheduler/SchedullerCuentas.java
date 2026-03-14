package com.utrng.sigecc.scheduler;

import com.utrng.sigecc.model.Pedido;
import com.utrng.sigecc.service.CorteCajaService;
import com.utrng.sigecc.service.PedidoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class SchedullerCuentas {

    @Autowired
    private PedidoService pedidoService;
    @Autowired
    private CorteCajaService corteCajaService;
    @Scheduled(cron = "0 59 23 L * ?")
    public void corteCajaMensual(){
        List<Pedido> pedidos = pedidoService.obtenerTodos();
        corteCajaService.guardarCorte(pedidos);
    }
}
