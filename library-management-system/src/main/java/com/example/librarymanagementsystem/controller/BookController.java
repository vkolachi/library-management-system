package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.requestDTO.BookRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.BookResponse;
import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.service.Impl.BookServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    BookServiceimpl bookServiceimpl;

    @PostMapping("/add")
    public BookResponse addBook(@RequestBody BookRequest bookRequest){

        try{
            BookResponse bookResponse = bookServiceimpl.addBook(bookRequest);
            return bookResponse;
        }
        catch (Exception e){
            return new BookResponse();
        }
    }

    @GetMapping("/getBooksByGenreAndCostGreaterThanSQL")
    public List<BookResponse> getBooksByGenreAndCostGreaterThanSQL(@RequestParam("genre")String genre,@RequestParam("cost") double cost){
        return bookServiceimpl.getBooksByGenreAndCostGreaterThanSQL(genre,cost);
    }


    @GetMapping("/getBooksByGenreAndCostGreaterThanHQL")
    public List<BookResponse> getBooksByGenreAndCostGreaterThanHQl(@RequestParam("genre")Genre genre,@RequestParam("cost") double cost){
        return bookServiceimpl.getBooksByGenreAndCostGreaterThanHQL(genre,cost);
    }

//
    // delete a book
    @DeleteMapping("/delete")
    public String deleteBook(@RequestParam("id") int id){
        return bookServiceimpl.deleteBook(id);
    }

    // give me names of all the books of a particular genre
    @GetMapping("inGenre")
    public List<String> inGenre(@RequestParam("genre")Genre genre){
        return bookServiceimpl.inGenre(genre);
    }

    // give me names of all the books of a particular genre and cost gretaer than 500 rs

    // give me all the books having number of pages between 'a' and 'b'

    // give me the names of all the authors who write a particular genre
    @GetMapping("perticular-genre")
    public List<String> perticularGenre(@RequestParam("genre")Genre genre){
        return bookServiceimpl.perticularGenre(genre);
    }


}
