package com.example.librarymanagementsystem.controller;

import com.example.librarymanagementsystem.DTO.requestDTO.StudentRequest;
import com.example.librarymanagementsystem.DTO.responseDTO.StudentResponse;
import com.example.librarymanagementsystem.service.Impl.StudentServiceImpl;
import com.example.librarymanagementsystem.model.Student;
import com.example.librarymanagementsystem.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/student")
public class StudentController {

    @Autowired
    StudentService studentService;

    @PostMapping("/add")
    public StudentResponse addStudent(@RequestBody StudentRequest studentRequest){
      StudentResponse studentResponse= studentService.addStudent(studentRequest);
        return  studentResponse;
    }

    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        StudentResponse student = studentService.getStudent(regNo);
        if(student!=null){
            return new ResponseEntity(student,HttpStatus.FOUND);
        }
        return new ResponseEntity("Invalid id!!",HttpStatus.BAD_REQUEST);
    }

    // delete a student --> regNo
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int regNo){
        return studentService.deleteStudent(regNo);

    }

    // update the age of a student  ---> regNo, age
    @PutMapping("/updateAge")
    public String updateAge(@RequestParam("id") int id,@RequestParam("newAge") int newAge){
        return studentService.updateAge(id,newAge);
    }

    // get all the students in the db  --> findAll()
    @GetMapping("/getAll")
    public List<Student> getAll(){

        return studentService.getAll();
    }

    // get list of all male students

    @GetMapping("/get-males")
    public List<String> getAllMales(){
        List<String> males = studentService.getAllMales();
        return males;
    }
}
