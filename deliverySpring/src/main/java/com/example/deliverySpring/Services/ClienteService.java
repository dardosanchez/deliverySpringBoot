package com.example.deliverySpring.Services;

import com.example.deliverySpring.Entidades.Cliente;
import com.example.deliverySpring.Entidades.Coordenada;
import com.example.deliverySpring.Repository.ClienteRepository;
import com.example.deliverySpring.Repository.CoordenadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteService {

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private CoordenadaRepository coordenadaRepository;

    public Cliente guardarCliente(Cliente cliente) {

        if (cliente.getCoordenada() != null) {
            Coordenada coordenada = cliente.getCoordenada();
            if (coordenada.getIdCoordenada() != null) {

                Optional<Coordenada> coordenadaExistente = coordenadaRepository.findById(coordenada.getIdCoordenada());
                if (coordenadaExistente.isPresent()) {
                    cliente.setCoordenada(coordenadaExistente.get());
                } else {
                    coordenada = coordenadaRepository.save(coordenada);
                    cliente.setCoordenada(coordenada);
                }
            } else {
                coordenada = coordenadaRepository.save(coordenada);
                cliente.setCoordenada(coordenada);
            }
        }
        return clienteRepository.save(cliente);
    }

    public List<Cliente> obtenerClientes() {
        return clienteRepository.findAll();
    }

    public Optional<Cliente> obtenerClientePorId(Integer id) {
        return clienteRepository.findById(id);
    }

    public Cliente actualizarCliente(Integer id, Cliente cliente) {
        if (clienteRepository.existsById(id)) {
            cliente.setId(id);
            return clienteRepository.save(cliente);
        }
        return null;
    }

    public boolean eliminarCliente(Integer id) {
        if (clienteRepository.existsById(id)) {
            clienteRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
