package com.example.demo.Model.Contoller;

import com.example.demo.DTO.Api;
import com.example.demo.Model.StudentClass;
import com.example.demo.Service.StudentService;
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
@RequestMapping("api/v1/Student")
public class StudentController {

    Logger log= LoggerFactory.getLogger(ClassRoomController.class);

    private final StudentService studentService;

    @GetMapping("/getStudent")
    public ResponseEntity<List<StudentClass>> getStudents(){
        List <StudentClass> students = studentService.getStudents();
        return ResponseEntity.status(HttpStatus.OK).body(students);
    }

    @PostMapping("/postStudent")
    public ResponseEntity <Api>addStudent(@RequestBody @Valid StudentClass studentClass ){
        studentService.addStudent(studentClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Api("New Student added !",201));
    }

}


