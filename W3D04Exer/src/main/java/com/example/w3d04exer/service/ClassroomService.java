package com.example.w3d04exer.service;

import com.example.w3d04exer.exceptions.InvalidIdException;
import com.example.w3d04exer.model.ManyToOne.Classroom;
import com.example.w3d04exer.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class ClassroomService {


    private final ClassroomRepository classroomRepository;
    public List<Classroom> getClassRooms() {
        return classroomRepository.findAll();
    }

    public void addClassRoom(Classroom classroom) {
        classroomRepository.save(classroom);
    }

    public Classroom checkClassRoomId(Integer id) {
        return classroomRepository.findById(id).orElseThrow(()-> new InvalidIdException("invalid id (Class Room not exist!!)"));
    }
}
