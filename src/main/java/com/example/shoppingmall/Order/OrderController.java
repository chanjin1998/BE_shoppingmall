package com.example.shoppingmall.Order;

import com.example.shoppingmall.Product.Product;
import com.example.shoppingmall.Product.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@AllArgsConstructor
@RestController
public class OrderController {
    // test /test

    OrderService orderService;
    ProductService productService;

    @PostMapping("/orders")
    public void orderProduct(@RequestBody OrderDTO orderDto){
        Product orderedProduct = productService.findProduct(orderDto.getProductId());
        //TODO : Service로 갈거야. DTO=>Entity
        Order requestOrder = new Order(orderedProduct,orderDto.getCount());

        orderService.orderProduct(requestOrder);
    }
}
// 유효성 검사
// 값이 있는지, 형식이 맞는지, 숫자를줘야하는데 문자를 줬을떄
// 검증 : 데이터가 중복인지 아닌지
// MemberController - 회원가입
// 1) DTO 끼워주고 변환 위치 설정해서 구현 : 생성자