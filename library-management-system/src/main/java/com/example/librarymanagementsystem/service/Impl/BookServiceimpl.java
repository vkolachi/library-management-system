package com.example.librarymanagementsystem.service.Impl;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.service.BookService;
import com.example.librarymanagementsystemsept.exception.AuthorNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookServiceimpl implements BookService {

    @Autowired
    AuthorRepository authorRepository;
    @Autowired
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
        bookResponse.setAuthorName(book.getAuthor().getName());
        bookResponse.setMessage("successfulll!!");
        return bookResponse;

    }


    public List<BookResponse> getBooksByGenreAndCostGreaterThanSQL(String genre, double cost) {
        List<Book> books=bookRepository.getBooksByGenreAndCostGreaterThanSQL(genre,cost);

        List<BookResponse> responses=new ArrayList<>();
        for(Book book:books){
//            BookResponse bookResponse=new BookResponse(book.getTitle(),book.getNoOfPages(),book.getCost(),book.getAuthor().getName(),"bookksssss!!!");
            //or
            BookResponse bookResponse=new BookResponse();
            bookResponse.setTitle(book.getTitle());
            bookResponse.setNoOfPages(book.getNoOfPages());
            bookResponse.setCost(book.getCost());
            bookResponse.setAuthorName(book.getAuthor().getName());
            bookResponse.setMessage("woowo");
            responses.add(bookResponse);
        }
        return responses;
    }

    public List<BookResponse> getBooksByGenreAndCostGreaterThanHQL(Genre genre, double cost) {
        List<Book> books=bookRepository.getBooksByGenreAndCostGreaterThanHQL(genre,cost);

        List<BookResponse> responses=new ArrayList<>();
        for(Book book:books){
//            BookResponse bookResponse=new BookResponse(book.getTitle(),book.getNoOfPages(),book.getCost(),book.getAuthor().getName(),"bookksssss!!!");
            //or
            BookResponse bookResponse=new BookResponse();
            bookResponse.setTitle(book.getTitle());
            bookResponse.setNoOfPages(book.getNoOfPages());
            bookResponse.setCost(book.getCost());
            bookResponse.setAuthorName(book.getAuthor().getName());
            bookResponse.setMessage("woowo");
            responses.add(bookResponse);
        }
        return responses;
    }

    public String deleteBook(int id) {
       if(bookRepository.existsById(id)){
           bookRepository.deleteById(id);
           return "deleted successfully";
       }
       return "Enter correct id";
    }

    public List<String> inGenre(Genre genre) {
        List<String> genreBook=new ArrayList<>();
        List<Book> bookList=bookRepository.findByGenre(genre);
        for(Book b:bookList){
            genreBook.add(b.getTitle());
        }
        return genreBook;
    }

    public List<String> perticularGenre(Genre genre) {
        List<String> authors=new ArrayList<>();
        List<Book> bookList=bookRepository.findAll();
        for(Book b:bookList){
            if(b.getGenre()==genre){
                authors.add(b.getAuthor().getName());
            }
        }
        return authors;
    }
}
