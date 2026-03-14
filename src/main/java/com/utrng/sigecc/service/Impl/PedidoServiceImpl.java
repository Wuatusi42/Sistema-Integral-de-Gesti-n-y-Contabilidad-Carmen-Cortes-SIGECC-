package com.utrng.sigecc.service.Impl;

import com.utrng.sigecc.model.Cliente;
import com.utrng.sigecc.model.DetallePedido;
import com.utrng.sigecc.model.Pedido;
import com.utrng.sigecc.model.Producto;
import com.utrng.sigecc.repository.ClienteDAO;
import com.utrng.sigecc.repository.DetallePedidoDAO;
import com.utrng.sigecc.repository.PedidoDAO;
import com.utrng.sigecc.repository.ProductoDAO;
import com.utrng.sigecc.service.PedidoService;
import com.utrng.sigecc.util.DetallePedidoDTO;
import com.utrng.sigecc.util.PedidoDTO;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
@Service
public class PedidoServiceImpl implements PedidoService {
    @Autowired
    private PedidoDAO pedidoRepository;

    @Autowired
    private DetallePedidoDAO detallePedidoRepository;

    @Autowired
    private ClienteDAO clienteRepository;

    @Autowired
    private ProductoDAO productoRepository;

    @Override
    public List<Pedido> obtenerTodos() {
        return pedidoRepository.findAll();
    }
    @Override
    @Transactional
    public void guardar(PedidoDTO dto) {

        // 1. Buscar cliente
        Cliente cliente = clienteRepository.findById(dto.getFkCliente())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado: " + dto.getFkCliente()));

        // 2. Crear y guardar pedido
        Pedido pedido = new Pedido();
        pedido.setStatusPedido(dto.getStatusPedido());
        pedido.setCliente(cliente);
        pedidoRepository.save(pedido);

        // 3. Guardar cada detalle
        if (dto.getDetalles() != null && !dto.getDetalles().isEmpty()) {
            for (DetallePedidoDTO detalleDTO : dto.getDetalles()) {

                Producto producto = productoRepository.findById(detalleDTO.getFkProducto())
                        .orElseThrow(() -> new RuntimeException("Producto no encontrado: " + detalleDTO.getFkProducto()));

                DetallePedido detalle = new DetallePedido();
                detalle.setPedido(pedido);
                detalle.setProducto(producto);
                detalle.setCantidad(detalleDTO.getCantidad());
                detalle.setTotal(
                        producto.getPrecio().multiply(BigDecimal.valueOf(detalleDTO.getCantidad()))
                );
                detallePedidoRepository.save(detalle);
            }
        }
    }
}
