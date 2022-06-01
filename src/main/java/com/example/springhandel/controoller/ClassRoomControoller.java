package com.example.springhandel.controoller;


import com.example.springhandel.model.Classrom;
import com.example.springhandel.model.Student;
import com.example.springhandel.repoistory.ClassRoomRepoistory;
import com.example.springhandel.servise.ClassromServies;
import com.example.springhandel.servise.StudentServies;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("api/v1/classroom")
public class ClassRoomControoller {
    Logger log=LoggerFactory.getLogger(ClassRoomControoller.class);

    private final ClassromServies classromServies;

    @GetMapping
    public ResponseEntity<List<Classrom>> getAllClassRoom() {
        log.info("classes are return by through getClasses()");

        return ResponseEntity.status(201).body(classromServies.getAllClassRoom());
    }

    @GetMapping("/{id}")
    public ResponseEntity <Classrom> getOneClassRoom(@PathVariable Integer id) {
        log.info("classes are return by through getClasses()");

        return ResponseEntity.status(201).body(classromServies.getOneClassRoom(id));
    }

    @PostMapping
    public ResponseEntity addClassRoom(@RequestBody Classrom classrom) {
        log.info("classes are added by through getClasses()");

        classromServies.addClassRoom(classrom);
        return ResponseEntity.status(200).body("ClassRoom added!");
    }


}