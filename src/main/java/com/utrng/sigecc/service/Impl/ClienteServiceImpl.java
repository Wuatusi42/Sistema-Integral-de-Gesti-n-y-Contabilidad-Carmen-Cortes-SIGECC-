package com.utrng.sigecc.service.Impl;

import com.utrng.sigecc.model.Cliente;
import com.utrng.sigecc.repository.ClienteDAO;
import com.utrng.sigecc.service.CLienteService;
import com.utrng.sigecc.util.ClienteDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImpl implements CLienteService {

    @Autowired
    private ClienteDAO clienteRepository;

    @Override
    public List<Cliente> obtenerTodos() {
        return clienteRepository.findAll();
    }
    @Override
    public void guardar(ClienteDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNombre(dto.getNombre());
        cliente.setTelefono(dto.getTelefono());
        cliente.setEstadoResidencia(dto.getEstadoResidencia());
        cliente.setMunicipioResidencia(dto.getMunicipioResidencia());
        cliente.setColonia(dto.getColonia());
        cliente.setNumeroCasa(dto.getNumeroCasa());
        cliente.setFechaRegistro(dto.getFechaRegistro());
        clienteRepository.save(cliente);
    }
}
