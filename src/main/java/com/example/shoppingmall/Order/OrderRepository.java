package com.example.shoppingmall.Order;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@Repository
public class OrderRepository {
    private int orderId = 0;
    private Map<Integer, Order> orderTable = new HashMap<>();
    public Integer createOrder(Order order) {

        log.info("order.name = {}",order.getProduct().getName());

        order.setOrderId(orderId++);
        orderTable.put(order.getOrderId(), order);

        Order savedOrder = orderTable.get(order.getOrderId());
        return savedOrder.getOrderId();
    }
}
