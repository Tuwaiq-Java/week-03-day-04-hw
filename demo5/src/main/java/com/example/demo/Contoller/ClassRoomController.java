package com.example.demo.Model.Contoller;

import com.example.demo.DTO.Api;
import com.example.demo.Model.ClassRoom;
import com.example.demo.Service.ClassRoomService;
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
@RequestMapping("api/v1/ClassRoom")
public class ClassRoomController {

    Logger log= LoggerFactory.getLogger(ClassRoomController.class);

    private final ClassRoomService classRoomService;



    @GetMapping("/getClass")
    public ResponseEntity <List<ClassRoom>> getClasses(){
        List <ClassRoom> classRooms = classRoomService.getClasses();
        return ResponseEntity.status(HttpStatus.OK).body(classRooms);
    }
    @PostMapping("/postClass")
    public ResponseEntity <Api> addClassRoom(@RequestBody @Valid ClassRoom classRoom){
        classRoomService.addClassRoom(classRoom);
        return ResponseEntity.status(HttpStatus.CREATED).body(
                new Api("New Class Room added !",201));

    }


}
