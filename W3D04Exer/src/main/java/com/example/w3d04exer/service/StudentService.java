package com.example.w3d04exer.service;


import com.example.w3d04exer.exceptions.InvalidIdException;
import com.example.w3d04exer.model.ManyToMany.Student;
import com.example.w3d04exer.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public List<Student> getStudents() {
        return studentRepository.findAll();
    }

    public void addStudents(Student student) {
         studentRepository.save(student);
    }

    public Student checkStudentId(Integer id ) {
         return studentRepository.findById(id).orElseThrow(()-> new InvalidIdException("invalid id (student not exist)"));

    }
}
