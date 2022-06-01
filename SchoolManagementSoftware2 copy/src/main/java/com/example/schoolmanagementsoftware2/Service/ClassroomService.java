package com.example.schoolmanagementsoftware2.Service;

import com.example.schoolmanagementsoftware2.Exception.InvalidIDException;
import com.example.schoolmanagementsoftware2.Model.Classroom;
import com.example.schoolmanagementsoftware2.Repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class ClassroomService {

    private final ClassroomRepository classroomRepository;

    public List<Classroom> getClassrooms() {
        return classroomRepository.findAll();
    }

    public void addClassrooms(Classroom classroom){
        classroomRepository.save(classroom);
    }

    public Classroom getOCR(Integer id) {
       return classroomRepository.findById(id)
                .orElseThrow(() -> new InvalidIDException("Invalid id"));
    }
}