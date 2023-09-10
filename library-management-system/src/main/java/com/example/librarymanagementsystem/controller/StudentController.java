package com.example.librarymanagementsystem.controller;

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
    public ResponseEntity addStudent(@RequestBody Student student){
        Student response= studentService.addStudent(student);
        return new ResponseEntity(response, HttpStatus.CREATED);
    }
    @GetMapping("/get")
    public ResponseEntity getStudent(@RequestParam("id") int regNo){
        Student student=studentService.getStudent(regNo);
        if(student!=null){
            return new ResponseEntity(student,HttpStatus.CREATED);
        }

            return new ResponseEntity("invalid id",HttpStatus.BAD_REQUEST);

    }
    @DeleteMapping("/delete")
    public String deleteStudent(@RequestParam("id") int regNo){
//        
        String response=studentService.deleteStudent(regNo);
        return response;
    }

//    @PostMapping("/ updateAge")
//    public String updateAge(@RequestParam("id") int regNo,@RequestParam("newAge") int newAge){
//        String response=studentService.updateAge(regNo,newAge);
//        return response;
//    }
    @GetMapping("/getAll")
    public List<Student> getAllStudents(){

        return studentService.getAllStudents();
    }
//    @GetMapping("/male")
//    public List<Student> getAllMaleStudents(){
//        return studentService.getAllMaleStudents();
//    }


    // update the age of a student  ---> regNo, age

    // get all the students in the db

    // get list of all male students

}
