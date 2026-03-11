package com.utrng.sigecc.model;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity
@Table(name = "corteCaja")
public class CorteCaja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCorteCaja", nullable = false)
    private Integer idCorteCaja;

    @Column(name = "fechaInicio", nullable = false)
    private LocalDateTime fechaInicio;

    @Column(name = "fechaFin", nullable = false)
    private LocalDateTime fechaFin;

    @Column(name = "totalVentas", precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private BigDecimal totalVentas;

    @Column(name = "totalPagos", precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private BigDecimal totalPagos;

    @Column(name = "diferencia", precision = 10, scale = 2, columnDefinition = "DECIMAL(10,2) DEFAULT 0")
    private BigDecimal diferencia;

    @Column(name = "statusCorte", length = 30, columnDefinition = "VARCHAR(30) DEFAULT 'Abierto'")
    private String statusCorte;

    @Column(name = "fechaGeneracion", nullable = false)
    private LocalDateTime fechaGeneracion;

    public Integer getIdCorteCaja() { return idCorteCaja; }
    public void setIdCorteCaja(Integer idCorteCaja) { this.idCorteCaja = idCorteCaja; }

    public LocalDateTime getFechaInicio() { return fechaInicio; }
    public void setFechaInicio(LocalDateTime fechaInicio) { this.fechaInicio = fechaInicio; }

    public LocalDateTime getFechaFin() { return fechaFin; }
    public void setFechaFin(LocalDateTime fechaFin) { this.fechaFin = fechaFin; }

    public BigDecimal getTotalVentas() { return totalVentas; }
    public void setTotalVentas(BigDecimal totalVentas) { this.totalVentas = totalVentas; }

    public BigDecimal getTotalPagos() { return totalPagos; }
    public void setTotalPagos(BigDecimal totalPagos) { this.totalPagos = totalPagos; }

    public BigDecimal getDiferencia() { return diferencia; }
    public void setDiferencia(BigDecimal diferencia) { this.diferencia = diferencia; }

    public String getStatusCorte() { return statusCorte; }
    public void setStatusCorte(String statusCorte) { this.statusCorte = statusCorte; }

    public LocalDateTime getFechaGeneracion() { return fechaGeneracion; }
    public void setFechaGeneracion(LocalDateTime fechaGeneracion) { this.fechaGeneracion = fechaGeneracion; }
}