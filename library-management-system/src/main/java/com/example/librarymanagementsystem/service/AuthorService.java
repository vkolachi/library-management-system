package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.AuthorRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.AuthorResponse;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.Student;

import java.util.List;

public interface AuthorService {
   AuthorResponse addAuthor(AuthorRequest authorRequest);

   String updateEmail(int id, String newEmail);

   List<Book> totalBooksByAuthor(int id);

   List<String> authorsWithXbooks( int x);



}
