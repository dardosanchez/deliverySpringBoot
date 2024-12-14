package com.example.deliverySpring.Entidades;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "pedido_detalle")
@Data
public class PedidoDetalle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne()
    @JoinColumn(name = "itemMenuId", referencedColumnName = "id")
    private ItemMenu itemMenu;

    @ManyToOne()
    @JoinColumn(name = "pedidoId", referencedColumnName = "id")
    @JsonBackReference
    private Pedido pedido;

    private Integer cantidad;


    public PedidoDetalle() {
    }

    public PedidoDetalle(Integer id, ItemMenu itemMenu, Pedido pedido, Integer cantidad) {
        this.id = id;
        this.itemMenu = itemMenu;
        this.pedido = pedido;
        this.cantidad = cantidad;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ItemMenu getItemMenu() {
        return itemMenu;
    }

    public void setItemMenu(ItemMenu itemMenu) {
        this.itemMenu = itemMenu;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Integer getCantidad() {
        return cantidad;
    }

    public void setCantidad(Integer cantidad) {
        this.cantidad = cantidad;
    }
}
