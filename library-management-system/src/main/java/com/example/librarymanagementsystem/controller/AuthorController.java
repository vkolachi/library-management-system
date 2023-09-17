package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.requestDTO.AuthorRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.AuthorResponse;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.service.AuthorService;
import com.example.librarymanagementsystem.service.Impl.AuthorServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/author")
public class AuthorController {

    @Autowired
    AuthorService authorService;

    @PostMapping("/add")
    public AuthorResponse addAuthor(@RequestBody AuthorRequest authorRequest){
       AuthorResponse authorResponse = authorService.addAuthor(authorRequest);
        return authorResponse;
    }
    // update the email id of an author  -->> observer lastActivity column
    @PutMapping("/updateEmail")
    public ResponseEntity updateEmail(@RequestParam("id") int id,@RequestParam("newEmail") String newEmail){
        String response= authorService.updateEmail(id,newEmail);
        return new ResponseEntity(response,HttpStatus.CREATED);
    }

    // Give me the names of all the books written by a partiular author
    @GetMapping("totalBooks")
    public ResponseEntity totalBooksByAuthor(@RequestParam("id") int id){
        List<Book> abc= authorService.totalBooksByAuthor(id);
        return new ResponseEntity(abc,HttpStatus.CREATED);
    }


    // give me the names of authors who have written more than 'x' number of books
    @GetMapping("authorsWithXbooks")
    public ResponseEntity authorsWithXbooks(@RequestParam("x") int x){
        List<String> a= authorService.authorsWithXbooks(x);
        return new ResponseEntity(a,HttpStatus.CREATED);
    }
}
