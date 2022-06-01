package com.example.schoolmmanagement.service;
import com.example.schoolmmanagement.exceptions.InvalidIdExceptions;
import com.example.schoolmmanagement.model.Student;
import com.example.schoolmmanagement.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentService {
    private final StudentRepository studentRepository;
    public List<Student> getStudent() {
        return studentRepository.findAll();
    }
    public boolean addSudent(Student student) {
         studentRepository.save(student);
          return true;
    }
    // endpoint that takes student id and return one student
    public void getStudentById(Long id){
        Optional<Student> studentId = studentRepository.findById(id);
        if (studentId.isEmpty()){
            throw new InvalidIdExceptions("Invalid ID");
        }
    }
}
