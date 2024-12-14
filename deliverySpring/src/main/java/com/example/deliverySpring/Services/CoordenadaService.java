package com.example.deliverySpring.Services;

import com.example.deliverySpring.Entidades.Coordenada;
import com.example.deliverySpring.Repository.CoordenadaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoordenadaService {

    @Autowired
    private CoordenadaRepository coordenadaRepository;


    public Coordenada guardarCoordenada(Coordenada coordenada) {
        return coordenadaRepository.save(coordenada);
    }

    public List<Coordenada> obtenerTodasLasCoordenadas() {
        return coordenadaRepository.findAll();
    }

    public Coordenada obtenerCoordenadaPorId(Integer id) {
        return coordenadaRepository.findById(id).orElse(null);
    }

    public Coordenada actualizarCoordenada(Integer id, Coordenada coordenada) {
        if (coordenadaRepository.existsById(id)) {
            coordenada.setIdCoordenada(id);
            return coordenadaRepository.save(coordenada);
        }
        return null;
    }


    public boolean eliminarCoordenada(Integer id) {
        if (coordenadaRepository.existsById(id)) {
            coordenadaRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

