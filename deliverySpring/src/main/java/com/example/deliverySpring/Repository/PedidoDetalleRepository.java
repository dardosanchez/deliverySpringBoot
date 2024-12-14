package com.example.deliverySpring.Repository;

import com.example.deliverySpring.Entidades.PedidoDetalle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PedidoDetalleRepository extends JpaRepository<PedidoDetalle,Integer> {
}
