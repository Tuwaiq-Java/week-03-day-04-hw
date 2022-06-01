package com.example.schoolmanagementsoftware2.Controller;

import com.example.schoolmanagementsoftware2.DTO.Api;
import com.example.schoolmanagementsoftware2.Model.Classroom;
import com.example.schoolmanagementsoftware2.Service.ClassroomService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/ classroom")
@RequiredArgsConstructor
public class ClassroomController {

    private final ClassroomService classroomService;

    Logger logger = LoggerFactory.getLogger(ClassroomController.class);
    @GetMapping
    public ResponseEntity<List<Classroom>> getClassrooms(){
        logger.info("getClassrooms");
        return ResponseEntity.status(HttpStatus.OK).body(classroomService.getClassrooms());
    }

    @PostMapping
    public ResponseEntity<Api> addClassrooms(@RequestBody @Valid Classroom classroom){
        logger.info("addClassrooms");
        classroomService.addClassrooms(classroom);
        return ResponseEntity.status(HttpStatus.CREATED.OK).body(new Api("New student added !", 201));
    }

    @GetMapping("class/{id}")
    public ResponseEntity<Classroom> getOneClassRooms(@PathVariable Integer id){
        logger.info("getOneClassRooms");
        return ResponseEntity.status(HttpStatus.OK).body(classroomService.getOCR(id));
    }
}