package com.example.librarymanagementsystem.service.Impl;

import com.example.librarymanagementsystem.DTO.requestDTO.AuthorRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.AuthorResponse;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;
import com.example.librarymanagementsystem.model.Author;

import com.example.librarymanagementsystem.model.Book;

import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.repository.AuthorRepository;
import com.example.librarymanagementsystem.service.AuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.ArrayList;
import java.util.List;


@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    AuthorRepository authorRepository;

    public AuthorResponse addAuthor(AuthorRequest authorRequest){
        Author author=new Author();
        author.setName(authorRequest.getName());
        author.setAge(authorRequest.getAge());
        author.setEmailId(authorRequest.getEmailId());

        Author savedAuthor=authorRepository.save(author);

        AuthorResponse authorResponse=new AuthorResponse();
        authorResponse.setName(author.getName());
        authorResponse.setEmailId(author.getEmailId());
        authorResponse.setLastActivity(author.getLastActivity());

        return authorResponse;

    }



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
    }}

