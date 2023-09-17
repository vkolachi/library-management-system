package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.responseDTO.IssueBookResponse;
import com.example.librarymanagementsystem.service.TransactionServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("transaction")
public class TransactionController {
   @Autowired
   TransactionServiceImpl transactionServiceImpl;
  @PostMapping("/issue/book-id/{book-id}/student-id/{student-id}")
    public ResponseEntity issueBook(@PathVariable("book-id") int bookId,
                                       @PathVariable("student-id") int studentId ){

       try {
           IssueBookResponse response = transactionServiceImpl.issueBook(bookId, studentId);
           return new ResponseEntity(response, HttpStatus.CREATED);
       }
       catch (Exception e){
           return new ResponseEntity(e.getMessage(), HttpStatus.BAD_REQUEST);
       }

    }
    //return book
}























