package com.example.demo.Service;

import com.example.demo.Model.ClassRoom;
import com.example.demo.Repository.ClassRoomRepository;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassRoomService {

    private final ClassRoomRepository classRoomRepository;


    public List<ClassRoom> getClasses() {
        return classRoomRepository.findAll();
    }

    public void addClassRoom(ClassRoom classRoom) {
         classRoomRepository.save(classRoom);
    }
}
