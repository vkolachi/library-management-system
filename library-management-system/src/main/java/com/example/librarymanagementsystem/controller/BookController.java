package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystemsept.exception.AuthorNotFoundException;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public String addBook(@RequestBody Book book){

        try{
            String response = bookService.addBook(book);
            return response;
        }
        catch (Exception e){
            return e.getMessage();
        }
    }

//
//    // delete a book
//    @DeleteMapping("/delete")
//    public String deleteBook()

    // give me names of all the books of a particular genre

    // give me names of all the books of a particular genre and cost gretaer than 500 rs

    // give me all the books having number of pages between 'a' and 'b'

    // give me the names of all the authors who write a particular genre


}
