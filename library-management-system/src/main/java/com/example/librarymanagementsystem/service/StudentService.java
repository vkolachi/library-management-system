package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;
import com.example.librarymanagementsystem.model.Student;

import java.util.List;

public interface StudentService {

    StudentResponse addStudent(StudentRequest studentRequest);

    StudentResponse getStudent(int regNo);

    List<String> getAllMales();

    List<String> getAllMales1();

    String deleteStudent(int regNo);

    String updateAge(int id, int newAge);

    List<Student> getAll();




}
