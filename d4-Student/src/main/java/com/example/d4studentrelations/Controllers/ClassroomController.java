package com.example.d4studentrelations.Controllers;

import com.example.d4studentrelations.Models.Classroom;

import com.example.d4studentrelations.Models.Student;
import com.example.d4studentrelations.REPO.ClassesRepo;
import com.example.d4studentrelations.REPO.StudentRepo;
import com.example.d4studentrelations.Service.ClassroomService;

import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;


@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/classroom")

public class ClassroomController {


    private final ClassroomService classroomService;
    private final ClassesRepo classesRepo;
    private final StudentRepo studentRepo;

    Logger logger = LoggerFactory.getLogger(ClassroomController.class);


    @GetMapping
    public ResponseEntity<List<Classroom>> getClasses(){
        logger.info("method getClasses in the controller is used");
        return ResponseEntity.status(200).body(classroomService.getClassrooms());

    }

    @PostMapping
    public ResponseEntity addClassroom(@RequestBody @Valid Classroom classroom){
        logger.info("method addClass in the controller is used");
        classroomService.addClasses(classroom);
        return ResponseEntity.status(200).body("Class Added!");
    }

    // return one
    @GetMapping("/getOne")
    public ResponseEntity<Classroom> getOneClass(@RequestParam Integer classid){
        logger.info("method getClassById in the controller is used");
        Classroom classroom = classroomService.OneClass(classid);
        return ResponseEntity.status(200).body(classroom);

    }
    @PostMapping("/class/{studentId}/{classId}")
    public ResponseEntity addStudentClass(@PathVariable Integer studentId,@PathVariable Integer classId){
        logger.info("method addStudentClass in the controller is used");
        Student student = studentRepo.findById(studentId).get();
        Classroom classroom = classesRepo.findById(classId).get();
        classroom.getStudentSet().add(student);
        classesRepo.save(classroom);

        return ResponseEntity.status(200).body("Added!");
    }

}
