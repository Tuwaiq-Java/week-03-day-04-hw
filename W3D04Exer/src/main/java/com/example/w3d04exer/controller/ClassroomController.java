package com.example.w3d04exer.controller;


import com.example.w3d04exer.DTO.Api;
import com.example.w3d04exer.model.ManyToOne.Classroom;
import com.example.w3d04exer.model.ManyToOne.Teacher;
import com.example.w3d04exer.service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/classroom")
@RequiredArgsConstructor
public class ClassroomController {

    Logger logger = LoggerFactory.getLogger(ClassroomController.class);


    private final ClassroomService  classroomService;





    @GetMapping
    public ResponseEntity<List<Classroom>> getClassRooms(){

        logger.info("User Request ( Get)");
        return ResponseEntity.status(200).body(classroomService.getClassRooms());
    }


    @PostMapping
    public ResponseEntity<Api> addClassRoom(@RequestBody @Valid Classroom classroom){

        logger.info("adding user");
        logger.trace("");
        classroomService.addClassRoom(classroom);
        return ResponseEntity.status(201).body(new Api("New Class Room is added",201));
    }



    @GetMapping("/find/{id}")
    public ResponseEntity<Classroom> checkClassRoom(@PathVariable Integer id ){
        logger.info("checking...");


        return ResponseEntity.status(200).body(classroomService.checkClassRoomId(id));
    }







}
