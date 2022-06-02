package com.example.demo.Model.Contoller;

import com.example.demo.DTO.Api;
import com.example.demo.Model.Teacher;
import com.example.demo.Service.TeacherService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@AllArgsConstructor
@RequestMapping("api/v1/Teacher")
public class TeacherController {

    Logger log= LoggerFactory.getLogger(ClassRoomController.class);

    private final TeacherService teacherService;

    @GetMapping("/getTeacher")
    public ResponseEntity <List<Teacher>> getTeachers(){
        List <Teacher> teachers= teacherService.getTeachers();
        return ResponseEntity.status(HttpStatus.OK).body(teachers);
    }
    @PostMapping("/postTeacher")
    public ResponseEntity <Api> addTeacher(@RequestBody @Valid Teacher teacher){
        teacherService.addTeacher(teacher);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Api("New Student added !",201));
    }
}
