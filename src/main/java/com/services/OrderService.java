package com.services;

import com.DAO.OrderDAO;
import com.entities.Order;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderService {

    private final OrderDAO orderDAO;

    @Autowired
    public OrderService(OrderDAO orderDAO) {
        this.orderDAO = orderDAO;
    }

    public void createOrder(Order order) {
        orderDAO.addOrder(order);
    }

    public Order findOrderById(int id) {
        return orderDAO.getOrderById(id);
    }

    public List<Order> listAllOrders() {
        return orderDAO.getAllOrders();
    }

    public void updateOrder(Order order) {
        orderDAO.updateOrder(order);
    }

    public void deleteOrder(int id) {
        orderDAO.deleteOrder(id);
    }
}
