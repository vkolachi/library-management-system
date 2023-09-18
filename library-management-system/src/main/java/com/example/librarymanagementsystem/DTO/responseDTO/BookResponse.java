package com.example.librarymanagementsystem.DTO.responseDTO;

import com.example.librarymanagementsystem.model.Author;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BookResponse {
    String title;

    int noOfPages;

    double cost;

    String authorName;
}
