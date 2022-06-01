package com.example.useradviceexample0304.controllers;

import com.example.useradviceexample0304.DTO.API;
import com.example.useradviceexample0304.models.Student;
import com.example.useradviceexample0304.services.ClassroomService;
import com.example.useradviceexample0304.services.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequiredArgsConstructor @RequestMapping("student")
public class StudentController {
    private final StudentService studentService;
    private final ClassroomService classroomService;

    @GetMapping
    public ResponseEntity getStudents(){
        return ResponseEntity.status(HttpStatus.OK).body(studentService.getStudents());
    }
    
    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid Student student){
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Created", 201));
    }
    @PostMapping("/add/{classId}/{studentId}")
    public ResponseEntity addStudenttoClass(@PathVariable Integer classId,@PathVariable Integer studentId){
        studentService.addClassToStudent( studentId, classId);

        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Added class to student", 201));
    }
}
