package com.utrng.sigecc.service;

import com.utrng.sigecc.model.Cliente;
import com.utrng.sigecc.util.ClienteDTO;

import java.util.List;

public interface CLienteService {
    List<Cliente> obtenerTodos();
    void guardar(ClienteDTO dto);  // ← agregar
}
