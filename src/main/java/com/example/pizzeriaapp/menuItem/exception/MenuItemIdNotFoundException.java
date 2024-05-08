package com.example.pizzeriaapp.menuItem.exception;

public class MenuItemIdNotFoundException extends RuntimeException{
    public MenuItemIdNotFoundException(String message) {
        super(message);
    }
}
