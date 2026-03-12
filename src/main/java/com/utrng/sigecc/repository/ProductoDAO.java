package com.utrng.sigecc.repository;

import com.utrng.sigecc.model.Producto;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductoDAO extends JpaRepository<Producto, Integer> {

}
