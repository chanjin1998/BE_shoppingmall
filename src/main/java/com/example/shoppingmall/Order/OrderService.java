package com.example.shoppingmall.Order;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class OrderService {

    OrderRepository orderRepository;

    public void orderProduct(Order order) {
        orderRepository.createOrder(order);
    }
}
