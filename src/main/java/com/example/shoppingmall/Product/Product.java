package com.example.shoppingmall.Product;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private int price;
    private String description;
    private int categoryId;

    // setter는 가능한 도메인 객체에는 만들지 말자!
    public Product(String name, int price, String description, int categoryId){
        this.name = name;
        this.price = price;
        this.description = description;
        this.categoryId = categoryId;
    }
}
