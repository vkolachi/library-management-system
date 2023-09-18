package com.example.librarymanagementsystem.transformer;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.model.Author;

public class BookTransformer {
    public static Book bookRequestTobook(BookRequest bookRequest){
        return Book.builder()
                .title(bookRequest.getTitle())
                .noOfPages(bookRequest.getNoOfPages())
                .genre(bookRequest.getGenre())
                .cost(bookRequest.getCost())
                .author(bookRequest.getAuthor())
                .build();
    }

    public static BookResponse bookToBookResponse(Book book){
        return BookResponse.builder()
                .title(book.getTitle())
                .noOfPages(book.getNoOfPages())
                .cost(book.getCost())
                .authorName(book.getAuthor().getName())
                .build();
    }
}
