package com.example.maven.maven.model;

import jakarta.persistence.*;
import java.util.Date;
import java.math.BigDecimal;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "valor_total", columnDefinition = "DECIMAL(10,2)")
    private BigDecimal valorTotal;

    @Column(length = 255)
    private String status;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_realizado")
    private Date dataRealizado;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_emtransito")
    private Date dataEmTransito;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_entregue")
    private Date dataEntregue;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "data_cancelado")
    private Date dataCancelado;

    // Construtores
    public Pedido() {}

    // Getters e Setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public BigDecimal getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(BigDecimal valorTotal) {
        this.valorTotal = valorTotal;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getDataRealizado() {
        return dataRealizado;
    }

    public void setDataRealizado(Date dataRealizado) {
        this.dataRealizado = dataRealizado;
    }

    public Date getDataEmTransito() {
        return dataEmTransito;
    }

    public void setDataEmTransito(Date dataEmTransito) {
        this.dataEmTransito = dataEmTransito;
    }

    public Date getDataEntregue() {
        return dataEntregue;
    }

    public void setDataEntregue(Date dataEntregue) {
        this.dataEntregue = dataEntregue;
    }

    public Date getDataCancelado() {
        return dataCancelado;
    }

    public void setDataCancelado(Date dataCancelado) {
        this.dataCancelado = dataCancelado;
    }

    // toString method para debug
    @Override
    public String toString() {
        return "Pedido{" +
                "id=" + id +
                ", valorTotal=" + valorTotal +
                ", status='" + status + '\'' +
                ", dataRealizado=" + dataRealizado +
                ", dataEmTransito=" + dataEmTransito +
                ", dataEntregue=" + dataEntregue +
                ", dataCancelado=" + dataCancelado +
                '}';
    }
}