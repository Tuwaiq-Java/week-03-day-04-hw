package com.example.school.controller;

import com.example.school.DTO.Api;
import com.example.school.model.Classroom;
import com.example.school.model.Teacher;
import com.example.school.repositroy.ClassRoomRepository;
import com.example.school.service.ClassRoomService;
import com.example.school.service.TeacherService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RequestMapping("api/v1/teacher")
@RestController
@RequiredArgsConstructor
public class TeacherController {

    private final TeacherService teacherService;
    private final ClassRoomService classRoomService;

    @GetMapping("/teacher")
    public ResponseEntity<List<Teacher>> getTeacher(){

        return ResponseEntity.status(200).body(teacherService.getTeacher());
    }
    @GetMapping("/Teacher/{id}")
    public ResponseEntity<Api> checkTeacherIsValid(@PathVariable Integer id){
        teacherService.checkTeacherById(id);
        return ResponseEntity.status(HttpStatus.OK).body(new Api("Valid Teacher",200));
    }

    @PostMapping("/add")
    public ResponseEntity<Api> addTeacher(@RequestBody @Valid Teacher teacher) throws IllegalAccessException{
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("New Teacher added ",201));
    }

}
