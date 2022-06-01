package com.example.week3day4.service;

import com.example.week3day4.exception.InvalidIDException;
import com.example.week3day4.model.ClassRoom;
import com.example.week3day4.model.Student;
import com.example.week3day4.repository.ClassRoomRepository;
import com.example.week3day4.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    private final ClassRoomRepository classRoomRepository;
    public List<Student> getStudents(){
        return studentRepository.findAll();
    }
    public void addStudent(Student student){
        studentRepository.save(student);
    }
    public Student getStudent(Integer stu_id){
        Optional<Student>student=studentRepository.findById(stu_id);
        if(student.isEmpty()){
            throw new InvalidIDException("Invalid User ID");
        }
        return student.get();
    }
    public void enrollStudent(Integer class_id,Integer stu_id){
        Optional<Student>student=studentRepository.findById(stu_id);
        if(student.isEmpty()){
            throw new InvalidIDException("Student not found");
        }
        Optional<ClassRoom> course=classRoomRepository.findById(class_id);
        if(course.isEmpty()){
            throw new InvalidIDException("Class not found");
        }
        student.get().getClasses().add(course.get());
        studentRepository.save(student.get());

    }
}
