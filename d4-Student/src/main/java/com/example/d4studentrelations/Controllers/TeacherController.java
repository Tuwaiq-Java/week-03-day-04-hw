package com.example.d4studentrelations.Controllers;


import com.example.d4studentrelations.Models.Classroom;
import com.example.d4studentrelations.Models.Teacher;
import com.example.d4studentrelations.Service.TeacherService;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/teacher")
public class TeacherController {

    private final TeacherService teacherService;
    Logger logger = LoggerFactory.getLogger(StudentController.class);

    @GetMapping
    public ResponseEntity<List<Teacher>> getTeachers(){
        logger.info("method getTeachers in the controller is used");

        return ResponseEntity.status(200).body(teacherService.getTeachers());

    }

    @PostMapping
    public ResponseEntity addTeacher(@RequestBody @Valid Teacher teacher){
        logger.info("method addTeacher in the controller is used");

        teacherService.addTeacher(teacher);
        return ResponseEntity.status(200).body("Added!");
    }

    // return one
    @GetMapping("/getOne")
    public ResponseEntity<Teacher> getOneTeacher(@RequestParam Integer teacherid){
        logger.info("method getOneTeacher in the controller is used");
        return ResponseEntity.status(200).body(teacherService.OneTeacher(teacherid));

    }


}
