package com.example.schoolmanagementsoftware2.Controller;

import com.example.schoolmanagementsoftware2.DTO.Api;
import com.example.schoolmanagementsoftware2.Model.Classroom;
import com.example.schoolmanagementsoftware2.Model.Student;
import com.example.schoolmanagementsoftware2.Service.StudentService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {

    private final StudentService studentService;
    Logger logger = LoggerFactory.getLogger(StudentController.class);
    @GetMapping
    public ResponseEntity<List<Student>> getStudents(){
        logger.info("getStudents");
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }

    @PostMapping
    public ResponseEntity<Api> addStudents(@RequestBody @Valid Student student){
        logger.info("addStudents");
        studentService.addStudents(student);
        return ResponseEntity.status(HttpStatus.CREATED.OK).body(new Api("New student added !", 201));
    }

    @GetMapping("student/{id}")
    public ResponseEntity<Student> getOneStudents(@PathVariable Integer id){
        logger.info("getOneStudents");
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getOS(id));
    }
}