package com.example.librarymanagementsystem.DTO.requestDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AuthorRequest {
    String name;

    int age;

    String emailId;

}
