package com.example.springhandel.controoller;


import com.example.springhandel.model.Api;
import com.example.springhandel.model.Student;
import com.example.springhandel.model.Teacher;
import com.example.springhandel.servise.StudentServies;
import com.example.springhandel.servise.TeacherServies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/teacher")
public class TeacherControoller {

    private final TeacherServies teacherServies;
    Logger log= LoggerFactory.getLogger(TeacherControoller.class);

    @GetMapping
    public ResponseEntity<List<Teacher>> getAllTeacher() {
        log.info("return all teacher by getAllTeacher");

        return ResponseEntity.status(201).body(teacherServies.getAllTeacher());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Teacher> getOneTeacher(@PathVariable Integer id) {
        log.info("return all teacher by getOneTeacher");

        return ResponseEntity.status(201).body(teacherServies.getOneTeacher(id));
    }

    @PostMapping
    public ResponseEntity addTeacher(@RequestBody Teacher teacher) {
        log.info("add Teacher  by addTeacher");
        teacherServies.addTeacher(teacher);
        return ResponseEntity.status(200).body("Teacher added!");
    }


    @PostMapping("enrooledteacher/{teacherid}/{class_id}")
    public ResponseEntity enroledTeacherToClass(@PathVariable Integer teacherid,@PathVariable Integer class_id){
        log.info("a enroled teacher  to class");
        teacherServies.enrooledTeacherToClass(teacherid,class_id);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Teacher enrooled to class",201));
    }
}