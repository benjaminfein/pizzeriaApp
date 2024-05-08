package com.example.pizzeriaapp.menuItem.controller;

import com.example.pizzeriaapp.menuItem.exception.MenuItemIdNotFoundException;
import com.example.pizzeriaapp.menuItem.model.MenuItem;
import com.example.pizzeriaapp.menuItem.service.MenuItemService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class MenuItemController {
    final MenuItemService menuItemService;

    public MenuItemController(MenuItemService menuItemService) {
        this.menuItemService = menuItemService;
    }

    @GetMapping("api/MenuItem")
    public List<MenuItem> findAll() {
        return menuItemService.findAll();
    }

    @PostMapping("api/createMenuItem")
    public HttpStatus createMenuItem(@RequestBody MenuItem menuItem) {
        menuItemService.createMenuItem(menuItem);
        return HttpStatus.OK;
    }

    @PutMapping("api/updateMenuItem/{id}")
    public HttpStatus updateMenuItem(@RequestBody MenuItem menuItem, @PathVariable Integer id) {
        try {
            MenuItem menuItemById = menuItemService.findById(id);
            menuItemService.updateMenuItem(menuItemById, menuItem);
            return HttpStatus.NO_CONTENT;
        } catch (Exception wrongIdWasWritten) {
            throw new MenuItemIdNotFoundException("No such menu item by written id");
        }
    }

    @DeleteMapping("api/deleteMenuItem/{id}")
    public HttpStatus deleteMenuItem(@PathVariable Integer id) {
        try {
            MenuItem menuItemById = menuItemService.findById(id);
            menuItemService.deleteMenuItem(menuItemById);
            return HttpStatus.NO_CONTENT;
        } catch (Exception wrongIdWasWritten) {
            throw new MenuItemIdNotFoundException("No such menu item by written id");
        }
    }
}
