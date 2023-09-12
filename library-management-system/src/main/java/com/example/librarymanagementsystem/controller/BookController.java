package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;
 @PostMapping("/add")
 public String addbook(@RequestBody Book book){
    try{
        String response=bookService.addbook(book);
        return response;
    }
    catch (Exception e){
        return e.getMessage();
    }

    }
}
