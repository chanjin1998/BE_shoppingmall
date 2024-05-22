package com.example.shoppingmall.Product;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Product {
    private String name;
    private int price;
    private String description;
    private int id;
    private int categoryId;

    // setter는 가능한 도메인 객체에는 만들지 말자!

}
