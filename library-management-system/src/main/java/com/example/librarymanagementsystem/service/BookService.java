package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.Enum.Genre;

import java.util.List;

public interface BookService {
    BookResponse addBook(BookRequest bookRequest);

    List<BookResponse> getBooksByGenreAndCostGreaterThanSQL(String genre, double cost);

    List<BookResponse> getBooksByGenreAndCostGreaterThanHQL(Genre genre, double cost);

    String deleteBook(int id);

    List<String> inGenre(Genre genre);

    List<String> perticularGenre(Genre genre);


    List<String> noOfPages(int no, int no1);
}
