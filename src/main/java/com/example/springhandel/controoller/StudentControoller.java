package com.example.springhandel.controoller;


import com.example.springhandel.model.Api;
import com.example.springhandel.model.Classrom;
import com.example.springhandel.model.Student;
import com.example.springhandel.repoistory.ClassRoomRepoistory;
import com.example.springhandel.servise.ClassromServies;
import com.example.springhandel.servise.StudentServies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.validation.Valid;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/student")
public class StudentControoller {

    private final StudentServies studentServies;
private final ClassromServies classromServies;
    Logger log= LoggerFactory.getLogger(StudentControoller.class);

    @GetMapping
    public ResponseEntity<List<Student>> getAllStudent() {
        log.info("students are return by getStudents() ");

        return ResponseEntity.status(201).body(studentServies.getAllStudent());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Student> getOneStudent(@PathVariable Integer id) {
        log.info("student are return by getoneStudents() ");

        return ResponseEntity.status(201).body(studentServies.getOneStudent(id));
    }


    @PostMapping
    public ResponseEntity addStudent(@RequestBody @Valid Student student) {
        log.info("student are add by addStudent() ");
        studentServies.addStudent(student);
        return ResponseEntity.status(200).body("Student added!");
    }

    @PutMapping("students/{classid}/{studentid}")
    public ResponseEntity enrolledStudentToClass(@PathVariable Integer classid,@PathVariable Integer studentid){
        log.info("a class is added to student and class is added to student ");
       studentServies.enrollStudentToClass(classid,studentid);
        return ResponseEntity.status(HttpStatus.CREATED).body(new Api("Student added to class",201));
    }

}