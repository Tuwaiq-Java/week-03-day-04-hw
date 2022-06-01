package com.example.useradviceexample0304.services;


import com.example.useradviceexample0304.models.Classroom;
import com.example.useradviceexample0304.models.Student;
import com.example.useradviceexample0304.repository.ClassroomRepository;
import com.example.useradviceexample0304.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassroomRepository classroomRepository;

    public List getStudents(){
        System.out.println(studentRepository.findAll());
            return studentRepository.findAll();

    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }



    public void addClassToStudent(Integer studentId, Integer classId){
        Student stu= studentRepository.findById(studentId).get();
        Classroom classroom = classroomRepository.findById(classId).get();
        stu.getClassrooms().add(classroom);
        studentRepository.save(stu);
    }

    public Student findStudentById(Integer studentId) {
        return studentRepository.findById(studentId).get();
    }
}
