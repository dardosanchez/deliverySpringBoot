package com.example.deliverySpring.Controllers;

import com.example.deliverySpring.Entidades.ItemMenu;
import com.example.deliverySpring.Services.ItemMenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/item-menu")
public class ItemMenuController {

    @Autowired
    private ItemMenuService itemMenuService;


    @PostMapping
    public ItemMenu createItemMenu(@RequestBody ItemMenu itemMenu) {
        return itemMenuService.createItemMenu(itemMenu);
    }

    @PutMapping("/{id}")
    public ItemMenu updateItemMenu(@PathVariable Integer id, @RequestBody ItemMenu itemMenu) {
        return itemMenuService.updateItemMenu(id, itemMenu);
    }


    @GetMapping("/{id}")
    public ItemMenu getItemMenuById(@PathVariable Integer id) {
        return itemMenuService.getItemMenuById(id);
    }


    @GetMapping
    public String mostrarItemsMenu(Model model) {
        List<ItemMenu> items = itemMenuService.getAllItemMenus();
        model.addAttribute("items", items);
        return "itemMenu";
    }


    @DeleteMapping("/{id}")
    public void deleteItemMenu(@PathVariable Integer id) {
        itemMenuService.deleteItemMenu(id);
    }
}
