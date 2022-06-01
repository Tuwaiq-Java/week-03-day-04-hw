package com.example.week3day4ex.controller;

import com.example.week3day4ex.model.API;
import com.example.week3day4ex.model.Classroom;
import com.example.week3day4ex.model.Student;
import com.example.week3day4ex.service.ClassroomService;
import com.example.week3day4ex.service.StudentService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("classroom")
@AllArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;

    Logger logger = LoggerFactory.getLogger(ClassroomController.class);
    @GetMapping
    public ResponseEntity<List<Classroom>> getClassroom(){
        logger.info("Get Classrooms");
        return ResponseEntity.status(200).body(classroomService.getClassroom());
    }

    @PostMapping
    public ResponseEntity<API> addClassroom(@RequestBody @Valid Classroom classroom){
        classroomService.addClassroom(classroom);
        logger.info("Add Classroom");
        return ResponseEntity.status(201).body(new API("Classroom added",201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Classroom> getOneClass(@PathVariable Integer id) {
        logger.info("Get One Classroom");
        return ResponseEntity.status(200).body(classroomService.getOneClass(id));
    }
}
