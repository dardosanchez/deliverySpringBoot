package com.example.deliverySpring.Entidades;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "item_menu")
@Data
public class ItemMenu {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nombre;

    @Column(columnDefinition = "TEXT")
    private String descripcion;
    private Double precio;
    private Double peso;
    private Integer calorias;

    @Column(name = "apto_Celiaco")
    private Boolean aptoCeliaco;
    @Column(name = "apto_Vegano")
    private Boolean aptoVegano;
    @Column(name = "graduacion_Alcohol")
    private Double graduacionAlcohol;
    private Double volumen;

    @ManyToOne()
    @JoinColumn(name = "vendedorId", referencedColumnName = "id")
    private Vendedor vendedor;

    public ItemMenu() {
    }

    public ItemMenu(Integer id, String nombre, String descripcion, Double precio, Double peso, Integer calorias, Boolean aptoCeliaco, Boolean aptoVegano, Double graduacionAlcohol, Double volumen, Vendedor vendedor) {
        this.id = id;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.precio = precio;
        this.peso = peso;
        this.calorias = calorias;
        this.aptoCeliaco = aptoCeliaco;
        this.aptoVegano = aptoVegano;
        this.graduacionAlcohol = graduacionAlcohol;
        this.volumen = volumen;
        this.vendedor = vendedor;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Vendedor getVendedor() {
        return vendedor;
    }

    public void setVendedor(Vendedor vendedor) {
        this.vendedor = vendedor;
    }

    public Double getVolumen() {
        return volumen;
    }

    public void setVolumen(Double volumen) {
        this.volumen = volumen;
    }

    public Double getGraduacionAlcohol() {
        return graduacionAlcohol;
    }

    public void setGraduacionAlcohol(Double graduacionAlcohol) {
        this.graduacionAlcohol = graduacionAlcohol;
    }

    public Boolean getAptoVegano() {
        return aptoVegano;
    }

    public void setAptoVegano(Boolean aptoVegano) {
        this.aptoVegano = aptoVegano;
    }

    public Boolean getAptoCeliaco() {
        return aptoCeliaco;
    }

    public void setAptoCeliaco(Boolean aptoCeliaco) {
        this.aptoCeliaco = aptoCeliaco;
    }

    public Double getPrecio() {
        return precio;
    }

    public void setPrecio(Double precio) {
        this.precio = precio;
    }

    public Integer getCalorias() {
        return calorias;
    }

    public void setCalorias(Integer calorias) {
        this.calorias = calorias;
    }

    public Double getPeso() {
        return peso;
    }

    public void setPeso(Double peso) {
        this.peso = peso;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
