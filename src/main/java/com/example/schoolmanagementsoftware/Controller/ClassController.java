package com.example.schoolmanagementsoftware.Controller;

import com.example.schoolmanagementsoftware.DTO.API;
import com.example.schoolmanagementsoftware.model.ModelClass;
import lombok.RequiredArgsConstructor;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.schoolmanagementsoftware.service.ClassService;

import javax.validation.Valid;
import java.util.List;
import java.util.logging.Logger;

@RestController
@RequestMapping("api/v1/class")
@RequiredArgsConstructor

public class ClassController {
    private final ClassService classService;

    Logger logger = (Logger) LoggerFactory.getLogger(ClassService.class);

    @GetMapping
    public ResponseEntity<List<ModelClass>> getClasses() {
        List<ModelClass> classes = classService.getClasses();
        return ResponseEntity.status(HttpStatus.OK).body(classes);


    }


    @PostMapping("/add/class")
    public ResponseEntity addClass(@RequestBody ModelClass modelClass) {
        classService.addClass(modelClass);
        return ResponseEntity.status(HttpStatus.CREATED).body(new API("class added !", 201));
    }




    @GetMapping("/class/{id}")
    public ResponseEntity<API> takesclass(@PathVariable Integer id){
        classService.takesclass(id);
        return ResponseEntity.status(HttpStatus.OK).body(new API("Valid user",200));
    }


    @PostMapping("/id")
    public ResponseEntity<API> takesclassid(@RequestBody @Valid ModelClass classid) {
        classService.takesclassid(classid);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new API("New user added !",201));
    }


}