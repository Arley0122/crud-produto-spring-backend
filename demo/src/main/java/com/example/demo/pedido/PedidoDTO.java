package com.example.demo.pedido;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import com.example.demo.shared.enums.StatusPedido;
public class PedidoDTO {

    private Long id;

    private Instant dataCriacao;

    @NotNull(message = "Total é obrigatório")
    @DecimalMin(value = "0.0", inclusive = true, message = "Total não pode ser negativo")
    private BigDecimal total;

    @NotNull(message = "Status é obrigatório")
    private StatusPedido status; // "ABERTO", "PAGO", "CANCELADO"

    private Long usuarioId;

    public PedidoDTO() {
    }

    public PedidoDTO(Long id, Instant dataCriacao, BigDecimal total, StatusPedido status, Long usuarioId) {
        this.id = id;
        this.dataCriacao = dataCriacao;
        this.total = total;
        this.status = status;
        this.usuarioId = usuarioId;
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
        return this.status;
    }

    public void setStatus(StatusPedido status) {
        this.status = status;
    }

    public Long getUsuarioId(){return this.usuarioId;}
    public void setUsuarioId(Long usuarioId){this.usuarioId = usuarioId;}

    // --------- CONVERSÃO DTO -> ENTIDADE ----------

    public Pedido toEntitySemUsuario() {
        Pedido pedido = new Pedido();
        pedido.setId(this.id);
        pedido.setDataCriacao(this.dataCriacao);
        pedido.setTotal(this.total);
        pedido.setStatus(this.status); // "ABERTO" -> StatusPedido.ABERTO
        //usuario será setado no service
        return pedido;
    }

    // --------- CONVERSÃO ENTIDADE -> DTO ----------

    public static PedidoDTO fromEntity(Pedido pedido) {
        if (pedido == null) {
            return null;
        }
        Long usuarioId = null;

        if(pedido.getUsuario() != null){
            usuarioId = pedido.getUsuario().getId();
        }
        return new PedidoDTO(
            pedido.getId(),
            pedido.getDataCriacao(),
            pedido.getTotal(),
            pedido.getStatus(), // StatusPedido.ABERTO -> "ABERTO"
            usuarioId
        
            
        );
    }
}