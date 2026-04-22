package com.example.demo.pedido;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import com.example.demo.shared.enums.StatusPedido;
import com.example.demo.usuario.Usuario;

@Entity
@Table(name = "pedidos")
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // quando o pedido foi criado
    @Column(nullable = false)
    private Instant dataCriacao;

    // valor total do pedido
    @Column(nullable = false)
    private BigDecimal total;

    // status do pedido (ABERTO, PAGO, CANCELADO)
    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 20)
    private StatusPedido status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario usuario;

    public Pedido() {
    }

    public Pedido(Long id, Instant dataCriacao, BigDecimal total, StatusPedido status) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.total = total;
        this.status = status;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Instant getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(Instant dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public StatusPedido getStatus() {
        return status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Usuario getUsuario(){return this.usuario;}
    public void setUsuario(Usuario usuario){this.usuario = usuario;}
}