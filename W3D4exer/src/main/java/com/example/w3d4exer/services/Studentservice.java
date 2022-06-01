package com.example.w3d4exer.services;

import com.example.w3d4exer.Repository.Studentrepo;
import com.example.w3d4exer.exeptions.InvalidId;
import com.example.w3d4exer.model.Classroom;
import com.example.w3d4exer.model.Students;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class Studentservice {

    private final Studentrepo studentrepo;

    public List<Students>  getStudents(){
        return studentrepo.findAll();
    }
    public Students getStudentById(Integer id){
        return studentrepo.findById(id).get();
    }

    public void addStudent(Students students){
        studentrepo.save(students);
    }

    public void checkstudentid(Integer id) {
        Students students=studentrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
    }
}
