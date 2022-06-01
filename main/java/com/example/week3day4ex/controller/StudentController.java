package com.example.week3day4ex.controller;

import com.example.week3day4ex.model.API;
import com.example.week3day4ex.model.Student;
import com.example.week3day4ex.service.StudentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("student")
@AllArgsConstructor
public class StudentController {
    private final StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @GetMapping
    public ResponseEntity<List<Student>> getStudent(){
        logger.info("Get Students");
        return ResponseEntity.status(200).body(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<API> addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        logger.info("Add Student");
        return ResponseEntity.status(201).body(new API("Student added",201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Student> getOneStudent(@PathVariable Integer id){
        logger.info("Get One Student");
        return ResponseEntity.status(200).body(studentService.getOneStudent(id));
    }

}
