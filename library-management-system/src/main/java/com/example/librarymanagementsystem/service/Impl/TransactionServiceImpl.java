package com.example.librarymanagementsystem.service.Impl;

import com.example.librarymanagementsystem.DTO.responseDTO.IssueBookResponse;
import com.example.librarymanagementsystem.Enum.TransactionStatus;
import com.example.librarymanagementsystem.exception.BookAlreadyIssuedException;
import com.example.librarymanagementsystem.exception.BookNotFoundException;
import com.example.librarymanagementsystem.exception.StudentNotFoundException;
import com.example.librarymanagementsystem.exception.transactionNotFoundException;
import com.example.librarymanagementsystem.model.Book;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.model.Transaction;
import com.example.librarymanagementsystem.repository.BookRepository;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.repository.TransactionRepository;
import com.example.librarymanagementsystem.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;

@Service
public class TransactionServiceImpl implements TransactionService {
    @Autowired
    StudentRepository studentRepository;
    @Autowired
    TransactionRepository transactionRepository;
    @Autowired
    BookRepository bookRepository;
    @Autowired
    JavaMailSender javaMailSender;
    public  IssueBookResponse issueBook(int bookId, int studentId) {

        Optional<Student> studentOptional=studentRepository.findById(studentId);
        if(studentOptional.isEmpty()){
            throw new StudentNotFoundException("student doest exists");
        }
        Optional<Book> bookOptional=bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new BookNotFoundException("book doesnt exists");
        }
        Book book=bookOptional.get();
        if(book.isIssued()){
            throw new BookAlreadyIssuedException("book is already issued");
        }
        //issue the book
        Student student=studentOptional.get();

        //create tranaction
        Transaction transaction=Transaction.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .transactionStatus(TransactionStatus.SUCCESS)
                .book(book)
                .libraryCard(student.getLibraryCard())
                .build();
        Transaction savedTransaction=transactionRepository.save(transaction);
        //update book
        book.setIssued(true);
        book.getTransactions().add(savedTransaction);

        //card changes
        student.getLibraryCard().getTransactions().add(savedTransaction);

       Book savedBook= bookRepository.save(book); //book and transaction
        Student savedStudent= studentRepository.save(student); //student and transaction

        //  send an email
        String text = "Hi! " + student.getName() + " The below book has been issued to you\n" +
                book.getTitle() + " \nThis is the transaction number: "+savedTransaction.getTransactionNumber();

        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom("kven241@gmail.com");
        simpleMailMessage.setTo(student.getEmail());
        simpleMailMessage.setSubject("Congrats!! Book Issued");
        simpleMailMessage.setText(text);

        javaMailSender.send(simpleMailMessage);


        return IssueBookResponse.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .bookName(savedBook.getTitle())
                .transactionStatus(savedTransaction.getTransactionStatus())
                .transactionTime(savedTransaction.getTransactionTime())
                .studentName(savedStudent.getName())
                .libraryCardNumber(savedStudent.getLibraryCard().getCardNo())
                .authorName(savedBook.getAuthor().getName())
                .build();
    }

    public String withDraw(int bookId,int transactionId){
        Optional<Book> bookOptional=bookRepository.findById(bookId);
        if(bookOptional.isEmpty()){
            throw new BookNotFoundException("book doesnt exists");
        }
        Book book=bookOptional.get();
        if(!book.isIssued()){
            throw new BookAlreadyIssuedException("book is not issued to anyone");
        }
        Optional<Transaction> transactionOptional=transactionRepository.findById(transactionId);
        if(transactionOptional.isEmpty()){
            throw new transactionNotFoundException("invalid transaction id");

        }
        //withdraw

        //delete trasaction
        Transaction transaction= Transaction.builder()
                .transactionNumber(String.valueOf(UUID.randomUUID()))
                .transactionStatus(TransactionStatus.SUCCESS)
                .book(book)
                .libraryCard(transactionOptional.get().getLibraryCard())
                .build();
        Transaction savedTransaction=transactionRepository.save(transaction);
        //dont issue book
        book.setIssued(false);
        book.getTransactions().add(transaction);
        transaction.getLibraryCard().getTransactions().add(transaction);
        Book savedBook= bookRepository.save(book); //book and transaction
        return "trasaction successful";




    }



}
