package com.example.d4studentrelations.Service;


import com.example.d4studentrelations.Models.Classroom;
import com.example.d4studentrelations.Models.Student;
import com.example.d4studentrelations.REPO.ClassesRepo;
import com.example.d4studentrelations.REPO.StudentRepo;
import com.example.d4studentrelations.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@AllArgsConstructor
public class StudentService {

    private final StudentRepo studentRepo;
    private final ClassesRepo classesRepo;
    private final ClassroomService classroomService;


    public List<Student> getStudents() {
        return studentRepo.findAll();

    }


    public void addStudent(Student student) {
        studentRepo.save(student);

    }

    public Student OneStudent(Integer studentid) {

       return studentRepo.findById(studentid).orElseThrow(()-> new IdNotFoundException("Wrong ID"));

}


}

