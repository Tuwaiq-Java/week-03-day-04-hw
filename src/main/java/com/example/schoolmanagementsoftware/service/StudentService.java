package com.example.schoolmanagementsoftware.service;

import com.example.schoolmanagementsoftware.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import com.example.schoolmanagementsoftware.model.ModelStudent;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;


    public List<ModelStudent> getStudent() {
        return studentRepository.findAll();


    }

//throws IllegalAccessException

    public void addStudent(ModelStudent student)
    {
         studentRepository.save(student);
    }

    public List<ModelStudent> takesstudent(Integer id) {

        return studentRepository.findAll();


    }

    public void takesstudentid(ModelStudent studentId) {

       studentId = studentRepository.findById(studentId)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
    }


    //-----------------------------------
}
