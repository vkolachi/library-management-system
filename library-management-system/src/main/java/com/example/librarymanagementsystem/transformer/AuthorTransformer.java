package com.example.librarymanagementsystem.transformer;

import com.example.librarymanagementsystem.DTO.requestDTO.AuthorRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.AuthorResponse;
import com.example.librarymanagementsystem.model.Author;

public class AuthorTransformer {

    public  static Author authorRequestToAuthor(AuthorRequest authorRequest){
        return  Author.builder()
                .name(authorRequest.getName())
                .age(authorRequest.getAge())
                .emailId(authorRequest.getEmailId())
                .build();

    }

    public static AuthorResponse authorToAuthorResponse(Author author){
        return AuthorResponse.builder()
                .name(author.getName())
                .emailId(author.getEmailId())
                .lastActivity(author.getLastActivity())
                .build();
    }

}
