package com.example.shoppingmall.generics;

import java.util.ArrayList;

public class MyStackDemo {
    public static void main(String[] args) {
        MyStack<Integer> stackStr = new MyStack();
        stackStr.push(1);
        stackStr.push(2);
        stackStr.push(3);

        System.out.println(stackStr.pop());
        System.out.println(stackStr.peek()); // 제일 마지막 요소

        System.out.println(stackStr.isEmpty());

        stackStr.printElem();
    }
}
class MyStack<T>{
    ArrayList<T> arrayList = new ArrayList<>();
    void push(T data){
        arrayList.add(data);
    }
    T pop(){
        int len = arrayList.size();
        return arrayList.remove(len-1);
    }
    T peek(){
        int len = arrayList.size();
        return arrayList.get(len-1);
    }
    String isEmpty(){
        int len = arrayList.size();
        if (len == 0)
            return "true";
        else
            return "false";
    }
    void printElem(){
        for (T elem : arrayList) {
            System.out.println(elem);
        }
    }

}