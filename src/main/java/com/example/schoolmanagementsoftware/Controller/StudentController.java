package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.DTO.API;
import lombok.RequiredArgsConstructor;
import com.example.schoolmanagementsoftware.model.ModelStudent;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.schoolmanagementsoftware.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/student")
@RequiredArgsConstructor
public class StudentController {
    private final StudentService studentService;

    @GetMapping("/student")
    public ResponseEntity<List<ModelStudent>> getStudent() {

        List<ModelStudent> students = studentService.getStudent();

        return ResponseEntity.status(HttpStatus.OK).body(students);

    }


    @PostMapping("/add/syudent")
    public ResponseEntity addStudent(@RequestBody ModelStudent student) {
        studentService.addStudent(student);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("Student added !", 201));
    }

//Create endpoint that takes student id and return one student (return bad request if student id is invalid)

  @GetMapping("/student/{id}")
  public ResponseEntity<API> takesstudent(@PathVariable Integer id){
      studentService.takesstudent(id);
     return ResponseEntity.status(HttpStatus.OK).body(new API("Valid user",200));
   }


      @PostMapping("/id")
   public ResponseEntity<API> takesstudentid(@RequestBody @Valid ModelStudent studentid) {
      studentService.takesstudentid(studentid);
      return ResponseEntity.status(HttpStatus.CREATED).body(
             new API("New user added !",201));
    }


}



