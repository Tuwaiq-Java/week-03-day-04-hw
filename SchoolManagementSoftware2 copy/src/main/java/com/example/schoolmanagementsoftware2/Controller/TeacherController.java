package com.example.schoolmanagementsoftware2.Controller;

import com.example.schoolmanagementsoftware2.DTO.Api;
import com.example.schoolmanagementsoftware2.Model.Classroom;
import com.example.schoolmanagementsoftware2.Model.Teacher;
import com.example.schoolmanagementsoftware2.Service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
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
        logger.info("addTeachers");
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getTeachers());
    }


    @PostMapping
    public ResponseEntity<Api> addTeachers(@RequestBody @Valid Teacher teacher){
        logger.info("addTeachers");
        teacherService.addTeachers(teacher);
        return ResponseEntity.status(HttpStatus.CREATED.OK).body(new Api("New teacher added !", 201));
    }

    @GetMapping("teacher/{id}")
    public ResponseEntity<Teacher> getOneTeachers(@PathVariable Integer id){
        logger.info("getOneTeachers");
        return ResponseEntity.status(HttpStatus.OK).body(teacherService.getOT(id));
    }
}