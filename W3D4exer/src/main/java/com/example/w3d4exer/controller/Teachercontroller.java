package com.example.w3d4exer.controller;

import com.example.w3d4exer.DTO.api;
import com.example.w3d4exer.Repository.Classroomrepo;
import com.example.w3d4exer.model.Students;
import com.example.w3d4exer.model.Teacher;
import com.example.w3d4exer.services.Teacherservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/teacher")
public class Teachercontroller {

private final Teacherservice teacherservice;
    Logger logger= LoggerFactory.getLogger(Teachercontroller.class);


    @GetMapping("/getteachers")
    public ResponseEntity getTeachers() {
        return ResponseEntity.status(200).body(teacherservice.getTeacher());
    }

    public ResponseEntity<api> checkTeacherid(@PathVariable Integer id){

        teacherservice.checkTeacherid(id);
        return ResponseEntity.status(200).body(new api("Valid teacher",200));
    }
    @GetMapping("/gettecherbyid/{id}")
    public ResponseEntity getTeacherById(@PathVariable Integer id)  {
        return ResponseEntity.status(200).body(teacherservice.getTeacherById(id));}

    @PostMapping("/addteacher")
    public ResponseEntity<String> addStudent(@RequestBody @Valid Teacher teacher)throws IllegalAccessException{
        teacherservice.addTeacher(teacher);
        return ResponseEntity.status(200).body("teacher is added..");
    }


}
