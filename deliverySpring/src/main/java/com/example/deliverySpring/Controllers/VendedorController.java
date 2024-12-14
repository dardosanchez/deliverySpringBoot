package com.example.deliverySpring.Controllers;

import com.example.deliverySpring.Entidades.Vendedor;
import com.example.deliverySpring.Services.VendedorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/vendedores")
public class VendedorController {

    @Autowired
    private VendedorService vendedorService;


    @PostMapping
    public Vendedor createVendedor(@RequestBody Vendedor vendedor) {
        return vendedorService.createVendedor(vendedor);
    }


    @PutMapping("/{id}")
    public Vendedor updateVendedor(@PathVariable Integer id, @RequestBody Vendedor vendedor) {
        return vendedorService.updateVendedor(id, vendedor);
    }


    @GetMapping("/{id}")
    public Vendedor getVendedorById(@PathVariable Integer id) {
        return vendedorService.getVendedorById(id);
    }


    @GetMapping
    public String mostrarVendedores(Model model) {
        List<Vendedor> vendedores = vendedorService.getAllVendedores();
        model.addAttribute("vendedores", vendedores);
        return "vendedores";
    }

    @DeleteMapping("/{id}")
    public void deleteVendedor(@PathVariable Integer id) {
        vendedorService.deleteVendedor(id);
    }
}



