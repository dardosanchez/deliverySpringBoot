package com.example.deliverySpring.Entidades;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;

@Entity
@Table(name = "cliente")
@Data
@AllArgsConstructor
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String nombre;
    private String cuit;
    private String email;
    private String direccion;

    @ManyToOne()
    @JoinColumn(name = "id_Coordenada", referencedColumnName = "idCoordenada")
    private Coordenada coordenada;

    public Cliente() {
    }

    public Cliente(Integer id, Coordenada coordenada, String direccion, String email, String cuit, String nombre) {
        this.id = id;
        this.coordenada = coordenada;
        this.direccion = direccion;
        this.email = email;
        this.cuit = cuit;
        this.nombre = nombre;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Coordenada getCoordenada() {
        return coordenada;
    }

    public void setCoordenada(Coordenada coordenada) {
        this.coordenada = coordenada;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}
