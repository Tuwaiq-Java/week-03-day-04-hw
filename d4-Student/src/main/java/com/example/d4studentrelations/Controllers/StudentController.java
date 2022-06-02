package com.example.d4studentrelations.Controllers;

import com.example.d4studentrelations.DTO.ResponseAPI;

import com.example.d4studentrelations.Models.Student;

import com.example.d4studentrelations.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class StudentController {

    private final StudentService studentService;

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudents(){
        logger.info("method getAllStudents in the controller is used");
        return ResponseEntity.status(200).body(studentService.getStudents());

    }

    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        logger.info("method addStudent in the controller is used");

        studentService.addStudent(student);
        return ResponseEntity.status(200).body("Added!");
    }


    // return one
    @GetMapping("/getOne")
    public ResponseEntity<Student> getOneStudent(@RequestParam Integer id){
        logger.info("method getOneStudent in the controller is used");
        Student student = studentService.OneStudent(id);
        return ResponseEntity.status(200).body(student);

    }


    }



