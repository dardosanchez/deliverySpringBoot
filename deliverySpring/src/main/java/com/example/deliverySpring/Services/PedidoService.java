package com.example.deliverySpring.Services;

import com.example.deliverySpring.Entidades.Cliente;
import com.example.deliverySpring.Entidades.Pedido;
import com.example.deliverySpring.Entidades.PedidoDetalle;
import com.example.deliverySpring.Entidades.Vendedor;
import com.example.deliverySpring.Repository.ClienteRepository;
import com.example.deliverySpring.Repository.PedidoDetalleRepository;
import com.example.deliverySpring.Repository.PedidoRepository;
import com.example.deliverySpring.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PedidoService {

    @Autowired
    private PedidoRepository pedidoRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private VendedorRepository vendedorRepository;

    public Pedido createPedido(Pedido pedido) {

        if (pedido.getCliente() == null || pedido.getVendedor() == null) {
            throw new IllegalArgumentException("El cliente y el vendedor son necesarios.");
        }

        // Verificar si el cliente y el vendedor existen
        clienteRepository.findById(pedido.getCliente().getId())
                .orElseThrow(() -> new RuntimeException("Cliente no encontrado"));

        vendedorRepository.findById(pedido.getVendedor().getId())
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));

        // Asociar los detalles con el pedido
        for (PedidoDetalle detalle : pedido.getPedidoDetalles()) {
            detalle.setPedido(pedido);  // Establecer la relación con el pedido
        }

        // Guardamos el pedido, y JPA se encarga de guardar los detalles
        return pedidoRepository.save(pedido);
    }

    public Pedido updatePedido(Integer id, Pedido pedido) {
        Pedido existingPedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        // Actualizamos los datos del pedido
        existingPedido.setEstado(pedido.getEstado());
        existingPedido.setTotal(pedido.getTotal());
        existingPedido.setFecha(pedido.getFecha());
        existingPedido.setMetodoPago(pedido.getMetodoPago());
        existingPedido.setCuit(pedido.getCuit());
        existingPedido.setAlias(pedido.getAlias());
        existingPedido.setCbu(pedido.getCbu());
        existingPedido.setCliente(pedido.getCliente());
        existingPedido.setVendedor(pedido.getVendedor());

        // Limpiamos los detalles antiguos y agregamos los nuevos
        existingPedido.getPedidoDetalles().clear();
        existingPedido.getPedidoDetalles().addAll(pedido.getPedidoDetalles());

        // Asociamos cada detalle al pedido
        for (PedidoDetalle detalle : existingPedido.getPedidoDetalles()) {
            detalle.setPedido(existingPedido);  // Asociamos los detalles al pedido actualizado
        }

        // Guardamos el pedido actualizado y sus detalles asociados
        return pedidoRepository.save(existingPedido);
    }

    public Pedido getPedidoById(Integer id) {
        return pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));
    }

    public List<Pedido> getAllPedidos() {
        return pedidoRepository.findAll();
    }

    public void deletePedido(Integer id) {
        Pedido pedido = pedidoRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Pedido no encontrado"));

        // Eliminamos los detalles asociados al pedido antes de eliminar el pedido
        pedido.getPedidoDetalles().clear();  // Limpia los detalles, para que JPA los elimine

        // Eliminamos el pedido
        pedidoRepository.delete(pedido);
    }
}


