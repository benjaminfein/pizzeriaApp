package com.example.pizzeriaapp.order.service;

import com.example.pizzeriaapp.order.model.Order;
import com.example.pizzeriaapp.order.repository.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {
    @Autowired
    public OrderRepository orderRepository;

    public List<Order> findAll() {
        return orderRepository.findAll();
    }

    public void createOrder(Order order) {
        orderRepository.save(order);
    }

    public Order findById(Integer id) {
        return orderRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("No such order by id: " + id));
    }

    public void updateOrder(Order exitingOrder, Order orderForUpdate) {
        orderForUpdate.setId(exitingOrder.getId());
        orderForUpdate.setUser(exitingOrder.getUser());
        orderForUpdate.setMenuItems(exitingOrder.getMenuItems());
        orderRepository.save(orderForUpdate);
    }

    public void deleteOrder(Order orderForDeletion) {
        orderRepository.delete(orderForDeletion);
    }
}
