package com.example.schoolmmanagement.controller;

import com.example.schoolmmanagement.DTO.ApiResponce;
import com.example.schoolmmanagement.model.Student;
import com.example.schoolmmanagement.service.StudentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public List<Student> getStudent(){
        logger.info("Request Get Student");
        return studentService.getStudent();
    }
    @PostMapping
    public ResponseEntity<ApiResponce> addStudent(@RequestBody @Valid Student student){
        var isAddStudent = studentService.addSudent(student);
        return ResponseEntity.status(201).body(new ApiResponce("Add Request :)",201));
    }
    // endpoint that takes student id and return one student
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponce> getStudentById(@PathVariable  Long id){
        studentService.getStudentById(id);
        return ResponseEntity.status(200).body(new ApiResponce("Nice Request :)",200));
    }
}
