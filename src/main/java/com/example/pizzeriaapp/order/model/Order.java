package com.example.pizzeriaapp.order.model;

import com.example.pizzeriaapp.menuItem.model.MenuItem;
import com.example.pizzeriaapp.user.model.User;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.List;

@Entity
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private User user;
    private List<MenuItem> menuItems;

    public Order() {}

    public Order(int id, User user, List<MenuItem> menuItems) {
        this.id = id;
        this.user = user;
        this.menuItems = menuItems;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<MenuItem> getMenuItems() {
        return menuItems;
    }

    public void setMenuItems(List<MenuItem> menuItems) {
        this.menuItems = menuItems;
    }
}
