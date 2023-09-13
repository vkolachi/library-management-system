package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Author;
<<<<<<< HEAD
import com.example.librarymanagementsystem.model.Book;
=======
>>>>>>> origin/main
import com.example.librarymanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

<<<<<<< HEAD
import java.util.ArrayList;
import java.util.List;

=======
>>>>>>> origin/main
@Service
public class AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor( Author author){
        Author savedAuthor=authorRepository.save(author);
        return "author saved successfully";
    }
<<<<<<< HEAD

    public String updateEmail(int id, String newEmail) {
        if(authorRepository.findById(id).isPresent()){
           Author author= authorRepository.findById(id).get();
           author.setEmailId(newEmail);
           authorRepository.save(author);
           return "updated successfully";
        }
        return "invalid id";
    }

    public List<Book> totalBooksByAuthor(int id) {
        if(authorRepository.findById(id).isPresent()){
            Author author= authorRepository.findById(id).get();
            return author.getBooks();
        }
        return null;
    }

    public List<String> authorsWithXbooks( int x) {
        List<Author> authors=new ArrayList<>();
        authors= authorRepository.findAll();
        List<String> names=new ArrayList<>();
        for(Author a:authors){
            if(a.getBooks().size()>x){
                names.add(a.getName());
            }
        }
        return names;
    }
=======
>>>>>>> origin/main
}
