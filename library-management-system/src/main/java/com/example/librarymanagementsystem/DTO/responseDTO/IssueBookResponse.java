package com.example.librarymanagementsystem.DTO.responseDTO;

import com.example.librarymanagementsystem.Enum.TransactionStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;
import org.hibernate.annotations.CreationTimestamp;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@FieldDefaults(level = AccessLevel.PRIVATE)
@Builder
public class IssueBookResponse {

   String transactionNumber;

   Date transactionTime;

   TransactionStatus transactionStatus;

   String bookName;

   String authorName;

   String studentName;

   String libraryCardNumber;

}
