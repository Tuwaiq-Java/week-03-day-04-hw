package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.DTO.API;
import com.example.schoolmanagementsoftware.model.ModelStudent;
import com.example.schoolmanagementsoftware.model.ModelTeacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
gii
import com.example.schoolmanagementsoftware.service.TeacherService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/teacher")
@RequiredArgsConstructor

public class TeacherController {
    private final TeacherService teacherService;

    @GetMapping("/teacher")
    public ResponseEntity<List<ModelTeacher>> getTeacher(){

        List<ModelTeacher> teachers=teacherService.getTeacher();

        return ResponseEntity.status(HttpStatus.OK).body(teachers);

    }
//---------------------------------------------

    @PostMapping("/add/teacher")
    public ResponseEntity addTecher(@RequestBody ModelTeacher teacher ){
        teacherService.addTecher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("teacher added !",201));
    }
    @GetMapping("/student/{id}")
    public ResponseEntity<API> takesTeacher(@PathVariable Integer id){
        teacherService.takesTeacher(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid user",200));
    }


    @PostMapping("/id")
    public ResponseEntity<API> takesTeacherid(@RequestBody @Valid ModelStudent studentid) {
        teacherService.takesstudentid(studentid);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New user added !",201));

}}
