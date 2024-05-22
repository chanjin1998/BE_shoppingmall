package com.example.shoppingmall.Order;

import com.example.shoppingmall.Product.Product;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Order {
    private int orderId;
//    private String orderName;
    Product product;
    private int orderCount;

    public Order(Product orderedProduct, int count) {
        this.product = orderedProduct;
        this.orderCount = count;
    }
}
