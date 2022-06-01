package com.example.w3d4exer.controller;

import com.example.w3d4exer.DTO.api;
import com.example.w3d4exer.model.Students;
import com.example.w3d4exer.services.Studentservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/student")
public class Studentcontroller {

 private final Studentservice studentservice;

    Logger logger= LoggerFactory.getLogger(Studentcontroller.class);
    @GetMapping("/getstudents")
    public ResponseEntity getStudent() {

        return ResponseEntity.status(200).body(studentservice.getStudents());
    }

    public ResponseEntity<api> checkStudentid(@PathVariable Integer id){

        studentservice.checkstudentid(id);
        return ResponseEntity.status(200).body(new api("Valid student",200));
    }
    @GetMapping("/getstudentbyid/{id}")
    public ResponseEntity getStudentById(@PathVariable Integer id) {
        return ResponseEntity.status(200).body(studentservice.getStudentById(id));}

    @PostMapping("/addstudent")
    public ResponseEntity<String> addStudent(@RequestBody Students student){
        studentservice.addStudent(student);
        logger.info("add new student");
        return ResponseEntity.status(200).body("student is added..");
    }
}
