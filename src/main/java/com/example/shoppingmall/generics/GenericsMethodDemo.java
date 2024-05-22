package com.example.shoppingmall.generics;

public class GenericsMethodDemo {

}
class GenericsMethod{
    static <T> GenericsClass<T> returnGenericsObject(){
        return new GenericsClass<>();
    }
}
class GenericsClass<T>{

}
//제네릭 클래스, 제네릭 메소드는 언제 사용할까