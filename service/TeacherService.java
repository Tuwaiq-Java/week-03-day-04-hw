package com.example.schoolmmanagement.service;
import com.example.schoolmmanagement.exceptions.InvalidIdExceptions;
import com.example.schoolmmanagement.model.Teacher;
import com.example.schoolmmanagement.repository.TeacherRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;
    public List<Teacher> getTeacher() {
        return teacherRepository.findAll();
    }
    public boolean addTeacher(Teacher  teacher) {
        teacherRepository.save(teacher);
          return true;
    }
    // endpoint that takes teacher id and return one teacher
    public void getTeacherById(Long id) {
        Optional<Teacher> teacherId = teacherRepository.findById(id);
        if (teacherId.isEmpty()){
            throw new InvalidIdExceptions("Invalid ID");
        }
    }
}
