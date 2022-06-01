package com.example.schoolmmanagement.controller;
import com.example.schoolmmanagement.DTO.ApiResponce;
import com.example.schoolmmanagement.model.Classroom;
import com.example.schoolmmanagement.service.ClassroomService;
import lombok.AllArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("api/v1/Classes")
@AllArgsConstructor
public class ClassroomController {
    private final ClassroomService classroomService;
    Logger logger = LoggerFactory.getLogger(ClassroomController.class);
    @GetMapping
    public List<Classroom> getClasses(){
        logger.info("Request Get Classroom");
        return classroomService.getClasses();
    }
    @PostMapping
    public ResponseEntity<ApiResponce> addClasses(@RequestBody @Valid Classroom  classroom) {
        classroomService.addClasses(classroom);
        return ResponseEntity.status(201).body(new ApiResponce("Add Request :)",201));
    }
    // endpoint that takes classroom id and return one classroom
    @GetMapping("/{id}")
    public ResponseEntity<ApiResponce> getClassesById(@PathVariable  Long id){
        classroomService.getClassesById(id);
        return ResponseEntity.status(200).body(new ApiResponce("Nice Request :)",200));
    }
}
