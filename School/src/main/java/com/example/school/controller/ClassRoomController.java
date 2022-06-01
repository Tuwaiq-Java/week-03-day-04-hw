package com.example.school.controller;

import com.example.school.DTO.Api;
import com.example.school.model.Classroom;
import com.example.school.service.ClassRoomService;
import com.example.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/class")
@RestController
@RequiredArgsConstructor
public class ClassRoomController {
    Logger logger= LoggerFactory.getLogger( ClassRoomController.class);
    private final ClassRoomService classRoomService;
    private final TeacherService teacherService;

    @GetMapping("/getclassroom")
    public ResponseEntity<List<Classroom>> getClassRoom(){
        logger.info("Get class");

        return ResponseEntity.status(200).body(classRoomService.getClassRoom());
    }
    @GetMapping("/classbyid/{id}")
    public ResponseEntity<Api> checkClassIsValid(@PathVariable Integer id){
     classRoomService.checkClassRoomById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid class",200));
    }

    @PostMapping("/addclass")
    public ResponseEntity<Api> addClassRoom(@RequestBody @Valid Classroom classroom) throws IllegalAccessException{
        logger.info("Class sdd");
        classRoomService.addClassRoom(classroom);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New class added ",201));
    }

    @GetMapping(value = "/addStudentToClass/{studentId}/{classId}")
    public ResponseEntity<Api> addStudentToClass(@PathVariable Integer classId, @PathVariable Integer studentId) {
        classRoomService.addStudentToClass(classId,studentId);
        return ResponseEntity.ok(new Api("student added to class",200));
    }
    @GetMapping(value = "/addteacherToClass/{classId}/{teachertId}")
    public ResponseEntity<Api> addTeacherToClass(@PathVariable Integer classId, @PathVariable Integer teachertId) {
        classRoomService.addTeacherToClass(classId,teachertId);
        return ResponseEntity.ok(new Api("Teacher added to class",200));
    }



}
