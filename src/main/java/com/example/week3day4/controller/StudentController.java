package com.example.week3day4.controller;

import com.example.week3day4.dto.Response;
import com.example.week3day4.model.Student;
import com.example.week3day4.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    Logger log= LoggerFactory.getLogger(StudentController.class);
    private final StudentService studentService;
    @GetMapping
    public ResponseEntity getStudents(){
        log.info("students are retrieved through getStudents() inside of student controller");
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }
    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        log.info("a student is added through addStudent() inside of student controller");
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Student added",201));
    }
    @GetMapping("{stu_id}")
    public ResponseEntity getStudent(@PathVariable Integer stu_id){
        log.info("a student is retrieved getStudent()");
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudent(stu_id));
    }

    @PutMapping("enroll/{class_id}/{stu_id}")
    public ResponseEntity enrollStudent(@PathVariable Integer class_id,@PathVariable Integer stu_id){
        log.info("a class is added to student - class is added to student - through enrollStudent() inside of Student controller");
        studentService.enrollStudent(class_id,stu_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Student added to class",201));
    }
}
