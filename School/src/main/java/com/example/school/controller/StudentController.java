package com.example.school.controller;

import com.example.school.DTO.Api;
import com.example.school.model.Student;
import com.example.school.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RequestMapping("api/v1/student")
@RestController
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;

    @GetMapping("/getstudents")
    public ResponseEntity<List<Student>> getStudent(){

        return ResponseEntity.status(200).body(studentService.getStudent());
    }
    @GetMapping("/studentbyid/{id}")
    public ResponseEntity<Api> checkStudentIsValid(@PathVariable Integer id){
      studentService.checkStudentById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid Student",200));
    }

    @PostMapping("/add")
    public ResponseEntity<Api> addUser(@RequestBody @Valid Student student) throws IllegalAccessException{
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New student added ",201));
    }
}
