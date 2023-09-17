package com.example.librarymanagementsystem.DTO.responseDTO;

import lombok.*;
import lombok.experimental.FieldDefaults;

import java.util.Date;

@FieldDefaults(level = AccessLevel.PRIVATE)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AuthorResponse {
    String name;

    String emailId;

    Date lastActivity;

    String message;
}
