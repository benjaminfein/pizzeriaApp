package com.example.pizzeriaapp.order.controller;

import com.example.pizzeriaapp.menuItem.exception.MenuItemIdNotFoundException;
import com.example.pizzeriaapp.order.model.Order;
import com.example.pizzeriaapp.order.service.OrderService;
import com.example.pizzeriaapp.user.model.User;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class OrderController {
    final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping("api/order")
    public List<Order> findAll() {
        return orderService.findAll();
    }

    @PostMapping("api/createOrder")
    public HttpStatus createOrder(@RequestBody Order order) {
        orderService.createOrder(order);
        return HttpStatus.OK;
    }

    @PutMapping("api/updateOrder/{id}")
    public HttpStatus updateOrder(@RequestBody Order order, @PathVariable Integer id) {
        try {
            Order orderById = orderService.findById(id);
            orderService.updateOrder(orderById, order);
            return HttpStatus.NO_CONTENT;
        } catch (Exception wrongIdWasWritten) {
            throw new MenuItemIdNotFoundException("No such order by written id");
        }
    }

    @DeleteMapping("api/deleteOrder/{id}")
    public HttpStatus deleteOrder(@PathVariable Integer id) {
        try {
            Order orderById = orderService.findById(id);
            orderService.deleteOrder(orderById);
            return HttpStatus.NO_CONTENT;
        } catch (Exception wrongIdWasWritten) {
            throw new MenuItemIdNotFoundException("No such order by written id");
        }
    }
}
