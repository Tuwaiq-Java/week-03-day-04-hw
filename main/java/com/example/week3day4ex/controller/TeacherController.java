package com.example.week3day4ex.controller;

import com.example.week3day4ex.model.API;
import com.example.week3day4ex.model.Classroom;
import com.example.week3day4ex.model.Teacher;
import com.example.week3day4ex.service.TeacherService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("teacher")
@AllArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping
    public ResponseEntity<List<Teacher>> getTeacher(){
        logger.info("Get Teachers");
        return ResponseEntity.status(200).body(teacherService.getTeachers());
    }

    @PostMapping
    public ResponseEntity<API> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        logger.info("Add Teacher");
        return ResponseEntity.status(201).body(new API("Teacher added",201));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Teacher> getOneTeacher(@PathVariable Integer id){
        logger.info("Get One Teacher");
        return ResponseEntity.status(200).body(teacherService.getOneTeacher(id));
    }
}
