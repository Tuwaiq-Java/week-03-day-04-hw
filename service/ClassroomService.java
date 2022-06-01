package com.example.schoolmmanagement.service;
import com.example.schoolmmanagement.exceptions.InvalidIdExceptions;
import com.example.schoolmmanagement.model.Classroom;
import com.example.schoolmmanagement.repository.ClassroomRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@AllArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    public List<Classroom> getClasses() {
        return classroomRepository.findAll();
    }
    public void addClasses(Classroom classroom) {
        classroomRepository.save(classroom);
    }
    // endpoint that takes classroom id and return one classroom
    public void getClassesById(Long id) {
        Optional<Classroom> classesId=classroomRepository.findById(id);
        if (classesId.isEmpty()){
            throw new InvalidIdExceptions("Invalid ID");
        }
    }
}
