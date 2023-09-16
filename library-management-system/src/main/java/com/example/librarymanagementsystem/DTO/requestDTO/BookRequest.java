package com.example.librarymanagementsystem.DTO.requestDTO;

import com.example.librarymanagementsystem.Enum.Genre;
import com.example.librarymanagementsystem.model.Author;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BookRequest {

    String title;

    int noOfPages;

    Genre genre;

    Double cost;

    Author author;
}
