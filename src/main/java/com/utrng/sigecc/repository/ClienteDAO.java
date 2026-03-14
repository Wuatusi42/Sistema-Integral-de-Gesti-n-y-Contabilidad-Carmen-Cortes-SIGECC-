package com.utrng.sigecc.repository;

import com.utrng.sigecc.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClienteDAO extends JpaRepository<Cliente,Integer> {
}
