package com.example.w3d4exer.controller;

import com.example.w3d4exer.DTO.ClassDTO;
import com.example.w3d4exer.DTO.api;
import com.example.w3d4exer.model.Classroom;
import com.example.w3d4exer.model.Students;
import com.example.w3d4exer.services.Classroomservice;
import com.example.w3d4exer.services.Teacherservice;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@RequestMapping("api/v1/class")
public class Classroomcontroller {

private final Classroomservice classroomservice;
private final Teacherservice teacherservice;

Logger logger= LoggerFactory.getLogger(Classroomcontroller.class);

    @GetMapping("/getclasses")

    public ResponseEntity getclassrooms() {

        return ResponseEntity.status(200).body(classroomservice.getClassroom());
    }

    @GetMapping("/getclassbyid/{id}")
    public ResponseEntity getClssroomById(@PathVariable Integer id) {

        return ResponseEntity.status(200).body(classroomservice.getClassroomById(id));}

    @GetMapping("/checkclassroomid/{id}")

    public ResponseEntity<api> checkClassroomid(@PathVariable Integer id){

        classroomservice.checkClassroomid(id);
        return ResponseEntity.status(200).body(new api("Valid classroom",200));
    }
    @PostMapping("/addclass/{idt}")
    public ResponseEntity<String> addClassroom(@PathVariable Integer idt,@RequestBody @Valid Classroom classroom)throws IllegalAccessException{
        classroomservice.addClassroom(idt,classroom);
        return ResponseEntity.status(200).body("class is added..");
    }
  /*  @PostMapping
    public ResponseEntity addClassroom2(@RequestBody Classroom classroom){
        classroomservice.addClassroom(classroom);
        return ResponseEntity.status(200).body("class is added..");*/

}
