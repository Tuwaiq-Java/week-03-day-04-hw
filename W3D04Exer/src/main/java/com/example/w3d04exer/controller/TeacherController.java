package com.example.w3d04exer.controller;

import com.example.w3d04exer.DTO.Api;
import com.example.w3d04exer.model.ManyToMany.Student;
import com.example.w3d04exer.model.ManyToOne.Teacher;
import com.example.w3d04exer.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {



private final TeacherService teacherService;

 Logger logger = LoggerFactory.getLogger(TeacherController.class);


    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers(){

        logger.info("User Request ( Get)");
        return ResponseEntity.status(200).body(teacherService.getTeachers());

    }


    @PostMapping
    public ResponseEntity<Api> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        logger.info("adding user");
        logger.trace("");
        return ResponseEntity.status(201).body(new Api("new Teacher is added",201));
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<Teacher> checkTeacher(@PathVariable Integer id ){

        logger.info("checking...");
        return ResponseEntity.status(200).body(teacherService.checkTeacherId(id));
    }



}
