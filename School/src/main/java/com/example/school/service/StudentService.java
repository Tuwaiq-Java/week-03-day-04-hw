package com.example.school.service;

import com.example.school.model.Student;
import com.example.school.repositroy.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;

    public List<Student> getStudent() {
        return studentRepository.findAll();
    }

    public void checkStudentById(Integer id) {
        studentRepository.findById(id).get();
    }

    public void addStudent(Student student)throws IllegalAccessException{
        studentRepository.save(student);
    }
}
