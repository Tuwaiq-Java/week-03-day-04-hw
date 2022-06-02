package com.example.d4studentrelations.Service;

import com.example.d4studentrelations.Models.Classroom;
import com.example.d4studentrelations.Models.Student;
import com.example.d4studentrelations.REPO.ClassesRepo;
import com.example.d4studentrelations.exceptions.IdNotFoundException;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@AllArgsConstructor

public class ClassroomService {

    private final ClassesRepo classesRepo;
    private final StudentService studentService;


    public List<Classroom> getClassrooms() {
        return classesRepo.findAll();

    }


    public void addClasses(Classroom classroom) {
        classesRepo.save(classroom);

    }

    public Classroom OneClass(Integer classid) {

       return classesRepo.findById(classid).orElseThrow(()-> new IdNotFoundException("Wrong ID"));
    }


}
