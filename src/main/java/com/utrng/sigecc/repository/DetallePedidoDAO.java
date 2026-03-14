package com.utrng.sigecc.repository;

import com.utrng.sigecc.model.DetallePedido;
import com.utrng.sigecc.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;

@Repository
public interface DetallePedidoDAO extends JpaRepository<DetallePedido, Integer> {
    // Obtener todos los detalles de un pedido
    List<DetallePedido> findByPedido(Pedido pedido);

    // Sumar el total directamente en la query
    @Query("SELECT SUM(d.total) FROM DetallePedido d WHERE d.pedido = :pedido")
    BigDecimal sumTotalByPedido(Pedido pedido);
}
