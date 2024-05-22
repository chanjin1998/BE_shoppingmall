package com.example.shoppingmall.generics;

import java.util.ArrayList;

public class GenericsDemo {
    public static void main(String[] args) {
//        Car[] cars = new Car[3];
//        cars[0] = new Bus();
//        cars[1] = new Taxi();
//        cars[2] = new Subway();
//
//        for (int i = 0;i<3;i++){
//            cars[i].sound();
//        }
//        ArrayList<Car> carArrayList = new ArrayList<>();
//        carArrayList.add(new Bus());
//        carArrayList.add(new Taxi());
//        carArrayList.add(new Subway());
//
//        for (int i = 0;i < carArrayList.size(); i++){
//            carArrayList.get(i).sound();
//        }

        CarList<Car> carList = new CarList<>();
        carList.add(new Taxi());
        carList.add(new Bus());
        carList.add(new Subway());

        for (int i = 0;i < carList.size(); i++){
            carList.get(i).sound();
        }
    }
}

class Car{
    void sound(){
        System.out.println("경적 소리");
    }
}
class Bus extends Car{
    void sound(){
        System.out.println("붕붕");
    }
}
class Taxi extends Car{
    void sound(){
        System.out.println("부르릉");
    }
}
class Subway extends Car{
    void sound(){
        System.out.println("위이잉");
    }
}
class CarList<T> {
    ArrayList<T> arrayList = new ArrayList<>();
    void add(T data){
        //arrayList에 car객체를 하나씩 추가
        arrayList.add(data);
    }
    T get(int idx){
        return arrayList.get(idx);
    }
    int size(){
        return arrayList.size();
    }
}