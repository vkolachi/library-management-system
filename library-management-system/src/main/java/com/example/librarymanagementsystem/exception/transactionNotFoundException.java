package com.example.librarymanagementsystem.exception;

public class transactionNotFoundException extends RuntimeException{
    public transactionNotFoundException(String message){
        super(message);
    }
}
