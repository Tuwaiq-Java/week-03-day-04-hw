package com.example.week3day4ex.service;

import com.example.week3day4ex.exception.InvalidIdException;
import com.example.week3day4ex.model.Classroom;
import com.example.week3day4ex.model.Student;
import com.example.week3day4ex.repo.ClassroomRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ClassroomService {

    private final ClassroomRepo classroomRepo;

    public List<Classroom> getClassroom() {
        return classroomRepo.findAll();
    }

    public void addClassroom(Classroom classroom){
        classroomRepo.save(classroom);
    }

    public Classroom getOneClass(Integer classId){
        return classroomRepo.findById(classId).orElseThrow(
                ()->new InvalidIdException("Invalid id"));
    }
}
