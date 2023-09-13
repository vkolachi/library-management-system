package com.example.librarymanagementsystemsept.exception;

public class AuthorNotFoundException extends RuntimeException{

    public AuthorNotFoundException(String message){
        super(message);
    }
}
