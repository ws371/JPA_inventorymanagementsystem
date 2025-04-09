package com.controllers;

import com.entities.Order;
import com.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/orders")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public List<Order> getAllOrders() {
        return orderService.listAllOrders();
    }

    @GetMapping("/{id}")
    public Order getOrderById(@PathVariable int id) {
        return orderService.findOrderById(id);
    }

    @PostMapping
    public void addOrder(@RequestBody Order order) {
        orderService.createOrder(order);
    }

    @PutMapping("/{id}")
    public void updateOrder(@PathVariable int id, @RequestBody Order order) {
        order.setOrderId(id);
        orderService.updateOrder(order);
    }

    @DeleteMapping("/{id}")
    public void deleteOrder(@PathVariable int id) {
        orderService.deleteOrder(id);
    }
}
