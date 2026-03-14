package com.utrng.sigecc.repository;

import com.utrng.sigecc.model.Pedido;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDAO extends JpaRepository<Pedido,Integer> {
}
