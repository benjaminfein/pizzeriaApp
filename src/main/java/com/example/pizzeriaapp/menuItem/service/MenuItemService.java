package com.example.pizzeriaapp.menuItem.service;

import com.example.pizzeriaapp.menuItem.model.MenuItem;
import com.example.pizzeriaapp.menuItem.repository.MenuItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuItemService {
    @Autowired
    public MenuItemRepository menuItemRepository;

    public List<MenuItem> findAll() {
        return menuItemRepository.findAll();
    }

    public void createMenuItem(MenuItem menuItem) {
        menuItemRepository.save(menuItem);
    }

    public MenuItem findById(Integer id) {
        return menuItemRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such menu item by id: " + id));
    }

    public void updateMenuItem(MenuItem exitingMenuItem, MenuItem menuItemForUpdate) {
        menuItemForUpdate.setId(exitingMenuItem.getId());
        menuItemForUpdate.setName(exitingMenuItem.getName());
        menuItemForUpdate.setPrice(exitingMenuItem.getPrice());
        menuItemForUpdate.setIngredients(exitingMenuItem.getIngredients());
        menuItemRepository.save(menuItemForUpdate);
    }

    public void deleteMenuItem(MenuItem menuItemForDeletion) {
        menuItemRepository.delete(menuItemForDeletion);
    }
}
