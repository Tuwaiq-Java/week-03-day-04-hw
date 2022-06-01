package com.example.useradviceexample0304.controllers;

import com.example.useradviceexample0304.DTO.API;
import com.example.useradviceexample0304.DTO.ClassroomDTO;
import com.example.useradviceexample0304.models.Classroom;
import com.example.useradviceexample0304.services.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController @RequiredArgsConstructor @RequestMapping("classroom")
public class ClassroomController {
    Logger logger = LoggerFactory.getLogger(ClassroomController.class);
    private final ClassroomService classroomService;

    @GetMapping
    public ResponseEntity getClassrooms(){
        return ResponseEntity.status(HttpStatus.OK).body(classroomService.getClassrooms());
    }
    
    @PostMapping
    public ResponseEntity addClassroom(@RequestBody @Valid Classroom classroom){
        classroomService.addClassroom(classroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Created", 201));
    }
    @PostMapping("/teaClass")
    public ResponseEntity addTeacher(@RequestBody ClassroomDTO classroomDTO){
        classroomService.addTeacherToClass(classroomDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Added teacher to class", 201));

    }
}
