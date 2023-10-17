package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.service.BookService;
import com.example.librarymanagementsystem.service.Impl.BookServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookService bookService;

    @PostMapping("/add")
    public BookResponse addBook(@RequestBody BookRequest bookRequest){

        try{
            BookResponse bookResponse = bookService.addBook(bookRequest);
            return bookResponse;
        }
        catch (Exception e){
            return new BookResponse();
        }
    }

    @GetMapping("/getBooksByGenreAndCostGreaterThanSQL")
    public List<BookResponse> getBooksByGenreAndCostGreaterThanSQL(@RequestParam("genre")String genre,@RequestParam("cost") double cost){
        return bookService.getBooksByGenreAndCostGreaterThanSQL(genre,cost);
    }


    @GetMapping("/getBooksByGenreAndCostGreaterThanHQL")
    public List<BookResponse> getBooksByGenreAndCostGreaterThanHQl(@RequestParam("genre")Genre genre,@RequestParam("cost") double cost){
        return bookService.getBooksByGenreAndCostGreaterThanHQL(genre,cost);
    }

//
    // delete a book
    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam("id") int id){
        return bookService.deleteBook(id);
    }

    // give me names of all the books of a particular genre
    @GetMapping("inGenre")
    public List<String> inGenre(@RequestParam("genre")Genre genre){
        return bookService.inGenre(genre);
    }



    // give me all the books having number of pages between 'a' and 'b'
    @GetMapping("/noOfPages")
    public List<String> noOfPages(@RequestParam("no") int no,@RequestParam("no1") int no1){
        return bookService.noOfPages(no,no1);
    }

    // give me the names of all the authors who write a particular genre
    @GetMapping("perticular-genre")
    public List<String> perticularGenre(@RequestParam("genre")Genre genre){
        return bookService.perticularGenre(genre);
    }


}
