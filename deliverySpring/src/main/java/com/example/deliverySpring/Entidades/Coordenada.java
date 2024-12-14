package com.example.deliverySpring.Entidades;


import jakarta.persistence.*;

@Entity
@Table(name = "coordenada")
public class Coordenada {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCoordenada")
    private Integer idCoordenada;
    private Double lat;
    private Double lng;

    public Coordenada() {
    }

    public Coordenada(Double lng, Integer idCoordenada, Double lat) {
        this.lng = lng;
        this.idCoordenada = idCoordenada;
        this.lat = lat;
    }

    public Integer getIdCoordenada() {
        return idCoordenada;
    }

    public void setIdCoordenada(Integer idCoordenada) {
        this.idCoordenada = idCoordenada;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }
}
