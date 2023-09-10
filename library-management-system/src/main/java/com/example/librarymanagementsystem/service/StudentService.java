package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    StudentRepository studentRepository;
    public Student addStudent(Student student) {
        Student savedStudent=studentRepository.save(student);
        return savedStudent;
    }

    public Student getStudent(int regNo) {
        Optional<Student> studentOptional=studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }

    public String deleteStudent(int regNo) {
        Optional<Student> studentOptional=studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            studentRepository.deleteById(regNo);
            return "deleted successfully";
        }
        return "invalid regNo";


    }

//    public String updateAge(int regNo, int newAge) {
//        Optional<Student> studentOptional=studentRepository.findById(regNo);
//        if(studentOptional.isPresent()){
//            studentRepository.update
//        }
//    }

    public List<Student> getAllStudents() {
        List<Student> students=new ArrayList<>();
        studentRepository.findAll().forEach(student -> students.add(student));
        return students;
    }

//    public List<Student> getAllMaleStudents() {
//        List<Student> students=new ArrayList<>();
//
//        return studentRepository.getAllMaleStudents();
//    }
}
