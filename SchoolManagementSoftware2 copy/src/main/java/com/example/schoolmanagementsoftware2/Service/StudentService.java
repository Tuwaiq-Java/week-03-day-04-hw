package com.example.schoolmanagementsoftware2.Service;

import com.example.schoolmanagementsoftware2.Exception.InvalidIDException;
import com.example.schoolmanagementsoftware2.Model.Student;
import com.example.schoolmanagementsoftware2.Repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService {

    private final StudentRepository studentRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }

    public void addStudents(Student student) {
        studentRepository.save(student);
    }

    public Student getOS(Integer id) {
          return studentRepository.findById(id)
                    .orElseThrow(() -> new InvalidIDException("Invalid id"));
    }
}
