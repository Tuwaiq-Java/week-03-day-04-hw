package com.example.useradviceexample0304.controllers;

import com.example.useradviceexample0304.DTO.API;
import com.example.useradviceexample0304.models.Teacher;
import com.example.useradviceexample0304.services.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequiredArgsConstructor @RequestMapping("teacher")
public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity getTeachers(){
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());
    }
    
    @PostMapping
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Created", 201));
    }

    @GetMapping("/{id}")
    public ResponseEntity getOneTeacher(@PathVariable Integer id){
        return ResponseEntity.status(200).body(teacherService.findTeacherById(id));
    }
}
