package com.example.deliverySpring.Repository;

import com.example.deliverySpring.Entidades.Coordenada;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CoordenadaRepository extends JpaRepository<Coordenada, Integer> {
}
