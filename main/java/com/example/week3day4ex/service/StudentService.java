package com.example.week3day4ex.service;

import com.example.week3day4ex.exception.InvalidIdException;
import com.example.week3day4ex.model.Student;
import com.example.week3day4ex.repo.StudentRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepo studentRepo;

    public List<Student> getStudents() {
       return studentRepo.findAll();
    }

    public void addStudent(Student student){
        studentRepo.save(student);
    }

    public Student getOneStudent(Integer studentId){
        return studentRepo.findById(studentId).orElseThrow(
                ()->new InvalidIdException("Invalid id"));
    }
}
