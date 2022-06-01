package com.example.week3day4ex.service;

import com.example.week3day4ex.exception.InvalidIdException;
import com.example.week3day4ex.model.Classroom;
import com.example.week3day4ex.model.Teacher;
import com.example.week3day4ex.repo.TeacherRepo;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class TeacherService {
    private final TeacherRepo teacherRepo;

    public List<Teacher> getTeachers() {
        return teacherRepo.findAll();
    }

    public void addTeacher(Teacher teacher){
        teacherRepo.save(teacher);
    }

    public Teacher getOneTeacher(Integer teacherId){
        return teacherRepo.findById(teacherId).orElseThrow(
                ()->new InvalidIdException("Invalid id"));
    }
}
