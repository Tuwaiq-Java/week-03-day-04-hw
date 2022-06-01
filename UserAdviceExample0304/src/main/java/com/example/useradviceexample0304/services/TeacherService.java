package com.example.useradviceexample0304.services;


import com.example.useradviceexample0304.models.Teacher;
import com.example.useradviceexample0304.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class TeacherService {
    private final TeacherRepository teacherRepository;

    public List getTeachers(){
            return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public Teacher findTeacherById(Integer teacherId) {
        return teacherRepository.findById(teacherId).get();
    }

}
