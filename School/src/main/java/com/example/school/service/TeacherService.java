package com.example.school.service;

import com.example.school.model.Student;
import com.example.school.model.Teacher;
import com.example.school.repositroy.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;

    public List<Teacher> getTeacher() {
       return teacherRepository.findAll();
    }
    public void checkTeacherById(Integer id) {
        teacherRepository.findById(id).get();
    }

    public Teacher addTeacher(Teacher teacher)throws IllegalAccessException{
      return   teacherRepository.save(teacher);
    }
}
