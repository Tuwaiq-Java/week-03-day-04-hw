package com.example.demo.Service;

import com.example.demo.Model.StudentClass;
import com.example.demo.Repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;

    public void addStudent(StudentClass studentClass){
        studentRepository.save(studentClass);
    }

    public List<StudentClass> getStudents(){
        return studentRepository.findAll();
    }
}
