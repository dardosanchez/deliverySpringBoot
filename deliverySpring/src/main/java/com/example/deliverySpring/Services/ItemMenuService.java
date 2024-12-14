package com.example.deliverySpring.Services;

import com.example.deliverySpring.Entidades.ItemMenu;
import com.example.deliverySpring.Entidades.Vendedor;
import com.example.deliverySpring.Repository.ItemMenuRepository;
import com.example.deliverySpring.Repository.VendedorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ItemMenuService {

    @Autowired
    private ItemMenuRepository itemMenuRepository;

    @Autowired
    private VendedorRepository vendedorRepository;


    public ItemMenu createItemMenu(ItemMenu itemMenu) {
        if (itemMenu.getVendedor() != null && itemMenu.getVendedor().getId() != null) {

            Vendedor vendedor = vendedorRepository.findById(itemMenu.getVendedor().getId())
                    .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
            itemMenu.setVendedor(vendedor);
        } else {
            throw new RuntimeException("El Vendedor no puede ser nulo al crear un ItemMenu");
        }

        return itemMenuRepository.save(itemMenu);
    }


    public ItemMenu updateItemMenu(Integer id, ItemMenu itemMenu) {

        ItemMenu existingItemMenu = itemMenuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemMenu no encontrado"));


        existingItemMenu.setNombre(itemMenu.getNombre());
        existingItemMenu.setDescripcion(itemMenu.getDescripcion());
        existingItemMenu.setPrecio(itemMenu.getPrecio());
        existingItemMenu.setPeso(itemMenu.getPeso());
        existingItemMenu.setCalorias(itemMenu.getCalorias());
        existingItemMenu.setAptoCeliaco(itemMenu.getAptoCeliaco());
        existingItemMenu.setAptoVegano(itemMenu.getAptoVegano());
        existingItemMenu.setGraduacionAlcohol(itemMenu.getGraduacionAlcohol());
        existingItemMenu.setVolumen(itemMenu.getVolumen());


        if (itemMenu.getVendedor() != null && itemMenu.getVendedor().getId() != null) {
            Vendedor vendedor = vendedorRepository.findById(itemMenu.getVendedor().getId())
                    .orElseThrow(() -> new RuntimeException("Vendedor no encontrado"));
            existingItemMenu.setVendedor(vendedor);
        }

        return itemMenuRepository.save(existingItemMenu);
    }


    public ItemMenu getItemMenuById(Integer id) {
        return itemMenuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemMenu no encontrado"));
    }


    public List<ItemMenu> getAllItemMenus() {
        return itemMenuRepository.findAll();
    }


    public void deleteItemMenu(Integer id) {
        ItemMenu itemMenu = itemMenuRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ItemMenu no encontrado"));
        itemMenuRepository.delete(itemMenu);
    }
}

