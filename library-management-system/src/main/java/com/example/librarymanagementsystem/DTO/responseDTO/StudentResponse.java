package com.example.librarymanagementsystem.DTO.responseDTO;

import jakarta.persistence.Entity;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Builder
public class StudentResponse {
    String name;

    String email;

    String message;
        //nested
    LibraryCardResponse libraryCardResponse;

}
