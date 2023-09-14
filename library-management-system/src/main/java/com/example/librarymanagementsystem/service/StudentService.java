package com.example.librarymanagementsystem.service;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;
import com.example.librarymanagementsystem.Enum.CardStatus;
import com.example.librarymanagementsystem.Enum.Gender;
import com.example.librarymanagementsystem.model.LibraryCard;
import com.example.librarymanagementsystem.repository.StudentRepository;
import com.example.librarymanagementsystem.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class StudentService {

    @Autowired
    StudentRepository studentRepository;

    public StudentResponse addStudent(StudentRequest studentRequest) {
        Student student=new Student();
        student.setName(studentRequest.getName());
        student.setAge(studentRequest.getAge());
        student.setEmail(studentRequest.getEmail());
        student.setGender(studentRequest.getGender());

        LibraryCard libraryCard = new LibraryCard();
        libraryCard.setCardNo(String.valueOf(UUID.randomUUID()));
        libraryCard.setCardStatus(CardStatus.ACTIVE);
        libraryCard.setStudent(student);

        student.setLibraryCard(libraryCard);  // set librarycard for student

        Student savedStudent = studentRepository.save(student); // save both student and library card
        StudentResponse studentResponse=new StudentResponse();
        studentResponse.setName(student.getName());
        studentResponse.setEmail(student.getEmail());
        studentResponse.setMessage("saved successfully!!");
        studentResponse.setNewlibrarycard(savedStudent.getLibraryCard().getCardNo());
        return studentResponse;
    }

    public Student getStudent(int regNo) {

        Optional<Student> studentOptional = studentRepository.findById(regNo);
        if(studentOptional.isPresent()){
            return studentOptional.get();
        }
        return null;
    }

    public List<String> getAllMales() {

        List<String> names = new ArrayList<>();
        List<Student> students = studentRepository.findByGender(Gender.MALE);
        for(Student s: students){

            names.add(s.getName());}
        return names;
    }


    public List<String> getAllMales1() {

        List<String> names = new ArrayList<>();
        List<Student> students = studentRepository.findAll();
        for(Student s: students){
            if(s.getGender().equals(Gender.MALE)){
                names.add(s.getName());}
        }

        return names;
    }

    public String deleteStudent(int regNo) {
        if(studentRepository.findById(regNo).isPresent()){
            studentRepository.deleteById(regNo);
            return "deleted successfully";
        }
        else{
            return "invalid regNo";
        }
    }

    public String updateAge(int id, int newAge) {
        if(studentRepository.findById(id).isPresent()){

            Student student1= studentRepository.findById(id).get();
            student1.setAge(newAge);
            studentRepository.save(student1);

            return "updated successfully";

        }
        return "invalid id";
    }

    public List<Student> getAll() {
        List<Student> all=new ArrayList<>();
        List<Student> allStud=studentRepository.findAll();
        all.addAll(allStud);
        return  all;
    }
}
