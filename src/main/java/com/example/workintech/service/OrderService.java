package com.example.workintech.service;

import com.example.workintech.entity.Order;
import java.util.List;

public interface OrderService {
    Order saveOrder(Order order);
    Order getOrderById(Long id);
    List<Order> getAllOrders();
    void deleteOrder(Long id);
}
