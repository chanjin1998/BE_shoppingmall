package com.example.shoppingmall.Product;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProductDTO {
    private int id;

    @NotBlank(message = "상품명은 필수 입력입니다.")
    private String name;

    @NotNull(message = "상품가격은 필수 입력입니다.")
    private int price;

    @NotBlank(message = "상품설명은 필수 입력입니다.")
    @Size(min = 1, max = 100, message = "상품 설명은 1~100자 이내입니다.")
    private String description;

    @NotNull(message = "카테고리명은 필수 입력입니다.")
    private int categoryId;

    public Product converToEntity(){
        return new Product(name,price,description,categoryId);
    }
}
