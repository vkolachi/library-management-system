package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystemsept.exception.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public BookResponse addBook(BookRequest bookRequest) {
        Book book=new Book();
        book.setTitle(bookRequest.getTitle());
        book.setNoOfPages(bookRequest.getNoOfPages());
        book.setGenre(bookRequest.getGenre());
        book.setCost(bookRequest.getCost());
        book.setAuthor(bookRequest.getAuthor());

        // check if author exists or not
        Optional<Author> authorOptional = authorRepository.findById(book.getAuthor().getId());
        if(authorOptional.isEmpty()){
            throw new AuthorNotFoundException("Invalid author id!!!");
        }

        Author author = authorOptional.get();
        book.setAuthor(author);
        author.getBooks().add(book);

        authorRepository.save(author);  // save both author and book

        BookResponse bookResponse=new BookResponse();
        bookResponse.setTitle(book.getTitle());
        bookResponse.setNoOfPages(book.getNoOfPages());
        bookResponse.setCost(book.getCost());
        bookResponse.setAuthor(book.getAuthor());
        bookResponse.setMessage("successfulll!!");
        return bookResponse;

    }
}
