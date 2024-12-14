package com.example.deliverySpring.Services;

import com.example.deliverySpring.Entidades.Coordenada;
import com.example.deliverySpring.Entidades.Vendedor;
import com.example.deliverySpring.Repository.CoordenadaRepository;
import com.example.deliverySpring.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VendedorService {

    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private CoordenadaRepository coordenadaRepository;


    public Vendedor createVendedor(Vendedor vendedor) {

        if (vendedor.getCoordenada() != null && vendedor.getCoordenada().getIdCoordenada() != null) {
            Coordenada coordenada = coordenadaRepository.findById(vendedor.getCoordenada().getIdCoordenada())
                    .orElseThrow(() -> new RuntimeException("Coordenada no encontrada"));
            vendedor.setCoordenada(coordenada);
        }


        return vendedorRepository.save(vendedor);
    }


    public Vendedor updateVendedor(Integer id, Vendedor vendedor) {

        Vendedor existingVendedor = vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));


        existingVendedor.setNombre(vendedor.getNombre());
        existingVendedor.setDireccion(vendedor.getDireccion());


        if (vendedor.getCoordenada() != null && vendedor.getCoordenada().getIdCoordenada() != null) {

            Coordenada coordenada = coordenadaRepository.findById(vendedor.getCoordenada().getIdCoordenada())
                    .orElseThrow(() -> new RuntimeException("Coordenada no encontrada"));
            existingVendedor.setCoordenada(coordenada);
        }


        return vendedorRepository.save(existingVendedor);
    }


    public Vendedor getVendedorById(Integer id) {
        return vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
    }


    public List<Vendedor> getAllVendedores() {
        return vendedorRepository.findAll();
    }


    public void deleteVendedor(Integer id) {
        Vendedor vendedor = vendedorRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
        vendedorRepository.delete(vendedor);
    }
}



