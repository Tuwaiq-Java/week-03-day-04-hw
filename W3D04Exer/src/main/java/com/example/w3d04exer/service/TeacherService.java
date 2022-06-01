package com.example.w3d04exer.service;

import com.example.w3d04exer.exceptions.InvalidIdException;
import com.example.w3d04exer.model.ManyToOne.Teacher;
import com.example.w3d04exer.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class TeacherService {

    private final TeacherRepository teacherRepository;
    public List<Teacher> getTeachers() {
        return teacherRepository.findAll();
    }

    public void addTeacher(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher checkTeacherId(Integer id) {

        return teacherRepository.findById(id).orElseThrow(()-> new InvalidIdException("invalid id (teacher no exist"));
    }
}
