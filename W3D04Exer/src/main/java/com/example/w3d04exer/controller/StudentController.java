package com.example.w3d04exer.controller;


import com.example.w3d04exer.DTO.Api;
import com.example.w3d04exer.model.ManyToMany.Student;
import com.example.w3d04exer.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor

// make the controller onlt for valid cases
public class StudentController {

    Logger logger = LoggerFactory.getLogger(StudentController.class);

    private final StudentService studentService;


    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        logger.info("User Request ( Get)");

        return ResponseEntity.status(200).body(studentService.getStudents());

    }


    @PostMapping
    public ResponseEntity<Api> addStudent(@RequestBody @Valid Student student){

        logger.info("adding user");
        logger.trace("");
        studentService.addStudents(student);
        return ResponseEntity.status(201).body(new Api("new Student added",201));
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<Student> checkStudent(@PathVariable Integer id ){

        logger.info("checking...");

        return ResponseEntity.status(200).body(studentService.checkStudentId(id ));
    }










}
