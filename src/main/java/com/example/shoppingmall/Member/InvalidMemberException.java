package com.example.shoppingmall.Member;

public class InvalidMemberException extends RuntimeException {
    public InvalidMemberException(String message) {
        super(message);
    }
}