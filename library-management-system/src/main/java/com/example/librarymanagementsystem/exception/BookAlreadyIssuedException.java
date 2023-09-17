package com.example.librarymanagementsystem.exception;

public class BookAlreadyIssuedException extends RuntimeException {
    public BookAlreadyIssuedException(String message){
        super(message);
    }
}
