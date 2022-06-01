package com.example.schoolmmanagement.controller;

import com.example.schoolmmanagement.DTO.ApiResponce;
import com.example.schoolmmanagement.model.Teacher;
import com.example.schoolmmanagement.service.TeacherService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@AllArgsConstructor
public class TeacherController {
    private final TeacherService teacherService;
    Logger logger = LoggerFactory.getLogger(TeacherController.class);

    @GetMapping
    public List<Teacher> getTeacher(){
        logger.info("Request Get Teacher");
        return teacherService.getTeacher();
    }
    @PostMapping
    public ResponseEntity<ApiResponce> addTeacher(@RequestBody @Valid Teacher  teacher){
        var isAddRequest = teacherService.addTeacher(teacher);
        return ResponseEntity.status(201).body(new ApiResponce("Add Request :)",201));
    }
    // endpoint that takes teacher id and return one teacher
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponce> getTeacherById(@PathVariable  Long id){
        teacherService.getTeacherById(id);
        return ResponseEntity.status(200).body(new ApiResponce("Nice Request :)",200));
    }
}
