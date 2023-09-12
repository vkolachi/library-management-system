package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.model.Author;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthorSevice {

    @Autowired
    AuthorRepository authorRepository;

    public String addAuthor( Author author){
        Author savedAuthor=authorRepository.save(author);
        return "author saved successfully";
    }
}
