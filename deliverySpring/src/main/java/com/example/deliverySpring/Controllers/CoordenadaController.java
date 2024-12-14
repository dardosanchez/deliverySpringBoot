package com.example.deliverySpring.Controllers;

import com.example.deliverySpring.Entidades.Coordenada;
import com.example.deliverySpring.Services.CoordenadaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/coordenadas")
public class CoordenadaController {

    @Autowired
    private CoordenadaService coordenadaService;

    @PostMapping
    public ResponseEntity<Coordenada> guardarCoordenada(@RequestBody Coordenada coordenada) {
        Coordenada nuevaCoordenada = coordenadaService.guardarCoordenada(coordenada);
        return new ResponseEntity<>(nuevaCoordenada, HttpStatus.CREATED);
    }

    @GetMapping
    public String obtenerCoordenadas(Model model) {
        List<Coordenada> coordenadas = coordenadaService.obtenerTodasLasCoordenadas();
        System.out.println("Coordenadas obtenidas: " + coordenadas);
        model.addAttribute("coordenadas", coordenadas);
        return "coordenadas";
    }


    @GetMapping("/{id}")
    public ResponseEntity<Coordenada> obtenerCoordenada(@PathVariable Integer id) {
        Coordenada coordenada = coordenadaService.obtenerCoordenadaPorId(id);
        if (coordenada != null) {
            return new ResponseEntity<>(coordenada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Coordenada> actualizarCoordenada(@PathVariable Integer id, @RequestBody Coordenada coordenada) {
        Coordenada coordenadaActualizada = coordenadaService.actualizarCoordenada(id, coordenada);
        if (coordenadaActualizada != null) {
            return new ResponseEntity<>(coordenadaActualizada, HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarCoordenada(@PathVariable Integer id) {
        boolean eliminado = coordenadaService.eliminarCoordenada(id);
        if (eliminado) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}

