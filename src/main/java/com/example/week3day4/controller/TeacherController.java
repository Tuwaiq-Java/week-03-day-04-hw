package com.example.week3day4.controller;

import com.example.week3day4.dto.Response;
import com.example.week3day4.model.Teacher;
import com.example.week3day4.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor
public class TeacherController {
    Logger log= LoggerFactory.getLogger(StudentController.class);
    private final TeacherService teacherService;

    @GetMapping
    public ResponseEntity getTeachers(){
        log.info("teachers are retrieved through getTeachers() inside of teacher controller");
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());
    }
    @PostMapping
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Teacher added",201));
    }
    @GetMapping("{tech_id}")
    public ResponseEntity getTeacher(@PathVariable Integer tech_id){
        log.info("a teacher is retrieved through getTeacher() inside of teacher controller");
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeacher(tech_id));
    }
    @PostMapping("assign/{tech_id}/{class_id}")
    public ResponseEntity assignTeacherToClass(@PathVariable Integer tech_id,@PathVariable Integer class_id){
        log.info("a teacher is assigned to a class - class is added to teacher -  through assignTeacherToClass() inside of teacher controller");
        teacherService.assignTeacherToClass(tech_id,class_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Teacher assigned to class",201));
    }
}
