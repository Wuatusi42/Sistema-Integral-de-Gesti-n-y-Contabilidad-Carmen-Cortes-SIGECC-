package com.utrng.sigecc.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "pedidos")
public class Pedido {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPedido", nullable = false)
	private Integer idPedido;

	@Column(name = "statusPedido", length = 35)
	private String statusPedido;

	@ManyToOne
	@JoinColumn(name = "fkCliente", nullable = false)
	private Cliente cliente;

	@OneToMany(mappedBy = "pedido", fetch = FetchType.EAGER)
	private List<DetallePedido> detalles;

	// ── Calculados, no se persisten en BD ──

	public Integer getTotalProductos() {
		if (detalles == null || detalles.isEmpty()) return 0;
		return detalles.stream()
				.mapToInt(d -> d.getCantidad() != null ? d.getCantidad() : 0)
				.sum();
	}

	public BigDecimal getTotal() {
		if (detalles == null || detalles.isEmpty()) return BigDecimal.ZERO;
		return detalles.stream()
				.map(d -> d.getTotal() != null ? d.getTotal() : BigDecimal.ZERO)
				.reduce(BigDecimal.ZERO, BigDecimal::add);
	}

	// ── Getters y Setters ──

	public Integer getIdPedido() { return idPedido; }
	public void setIdPedido(Integer idPedido) { this.idPedido = idPedido; }

	public String getStatusPedido() { return statusPedido; }
	public void setStatusPedido(String statusPedido) { this.statusPedido = statusPedido; }

	public Cliente getCliente() { return cliente; }
	public void setCliente(Cliente cliente) { this.cliente = cliente; }

	public List<DetallePedido> getDetalles() { return detalles; }
	public void setDetalles(List<DetallePedido> detalles) { this.detalles = detalles; }
}