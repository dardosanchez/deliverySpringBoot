package com.example.deliverySpring.Entidades;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.Data;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@Data
public class Pedido {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String estado;
    private Double total;
    private Date fecha;

    @ManyToOne()
    @JoinColumn(name = "clienteId", referencedColumnName = "id")
    private Cliente cliente;

    private String metodoPago;
    private String cuit;
    private String alias;
    private String cbu;

    @ManyToOne()
    @JoinColumn(name = "vendedorId", referencedColumnName = "id")
    private Vendedor vendedor;


    @OneToMany(mappedBy = "pedido", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference  // Indica que esta es la referencia "principal"
    private List<PedidoDetalle> pedidoDetalles = new ArrayList<>();

    public Pedido() {
    }

    public Pedido(Integer id, String estado, Double total, Date fecha, Cliente cliente, String metodoPago, String cuit, String alias, String cbu, Vendedor vendedor, List<PedidoDetalle> pedidoDetalles) {
        this.id = id;
        this.estado = estado;
        this.total = total;
        this.fecha = fecha;
        this.cliente = cliente;
        this.metodoPago = metodoPago;
        this.cuit = cuit;
        this.alias = alias;
        this.cbu = cbu;
        this.vendedor = vendedor;
        this.pedidoDetalles = pedidoDetalles;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String getMetodoPago() {
        return metodoPago;
    }

    public void setMetodoPago(String metodoPago) {
        this.metodoPago = metodoPago;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getCbu() {
        return cbu;
    }

    public void setCbu(String cbu) {
        this.cbu = cbu;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public List<PedidoDetalle> getPedidoDetalles() {
        return pedidoDetalles;
    }

    public void setPedidoDetalles(List<PedidoDetalle> pedidoDetalles) {
        this.pedidoDetalles = pedidoDetalles;
    }
}
