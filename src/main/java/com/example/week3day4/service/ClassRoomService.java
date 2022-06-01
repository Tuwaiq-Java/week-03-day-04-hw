package com.example.week3day4.service;

import com.example.week3day4.exception.InvalidIDException;
import com.example.week3day4.model.ClassRoom;
import com.example.week3day4.repository.ClassRoomRepository;
import com.example.week3day4.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;
    private final StudentRepository studentRepository;
    public List<ClassRoom> getClasses(){
        return classRoomRepository.findAll();
    }
    public void addClassroom(ClassRoom aClass){
        classRoomRepository.save(aClass);
    }

    public ClassRoom getClass(Integer class_id){
        Optional<ClassRoom> aClass=classRoomRepository.findById(class_id);
        if(aClass.isEmpty()){
            throw new InvalidIDException("Invalid Class ID");
        }
        return aClass.get();
    }

}
