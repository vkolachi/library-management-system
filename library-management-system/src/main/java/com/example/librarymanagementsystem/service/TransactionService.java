package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.responseDTO.IssueBookResponse;

public interface TransactionService {
    IssueBookResponse issueBook(int bookId, int studentId);
}
