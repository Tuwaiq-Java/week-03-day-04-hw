package com.example.week3day4.controller;

import com.example.week3day4.dto.Response;
import com.example.week3day4.model.ClassRoom;
import com.example.week3day4.service.ClassRoomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("api/v1/classroom")
@RequiredArgsConstructor
public class ClassRoomController {
    Logger log=LoggerFactory.getLogger(ClassRoomController.class);
    private final ClassRoomService classRoomService;
    @GetMapping
    public ResponseEntity getClasses(){
        log.info("classes are retrieved through getClasses() inside of Classroom controller");
        return ResponseEntity.status(HttpStatus.OK).body(classRoomService.getClasses());
    }
    @PostMapping
    public ResponseEntity addClassroom(@RequestBody @Valid ClassRoom aClass){
        log.info("a class is added through addClassroom() inside of Classroom controller");
        classRoomService.addClassroom(aClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Response("Class added",201));
    }
    @GetMapping("{class_id}")
    public ResponseEntity getClass(@PathVariable Integer class_id){
        log.info("a class is retrieved through getClass() inside of Classroom controller");
        return ResponseEntity.status(HttpStatus.OK).body(classRoomService.getClass(class_id));
    }
}
