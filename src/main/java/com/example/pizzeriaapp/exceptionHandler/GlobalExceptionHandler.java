package com.example.pizzeriaapp.exceptionHandler;

import com.example.pizzeriaapp.menuItem.exception.MenuItemIdNotFoundException;
import com.example.pizzeriaapp.order.exception.OrderIdNotFoundException;
import com.example.pizzeriaapp.user.exception.UserIdNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(value = MenuItemIdNotFoundException.class)
    public ResponseEntity<Object> handleMenuItemException(MenuItemIdNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = UserIdNotFoundException.class)
    public ResponseEntity<Object> handleUserException(UserIdNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(value = OrderIdNotFoundException.class)
    public ResponseEntity<Object> handleOrderException(OrderIdNotFoundException exception) {
        return new ResponseEntity<>(exception.getMessage(), HttpStatus.NOT_FOUND);
    }
}
