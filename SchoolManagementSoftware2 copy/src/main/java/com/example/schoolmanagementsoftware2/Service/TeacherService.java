package com.example.schoolmanagementsoftware2.Service;

import com.example.schoolmanagementsoftware2.Exception.InvalidIDException;
import com.example.schoolmanagementsoftware2.Model.Teacher;
import com.example.schoolmanagementsoftware2.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }

    public void addTeachers(Teacher teacher) {
        teacherRepository.save(teacher);
    }

    public Teacher getOT(Integer id) {
          return   teacherRepository.findById(id)
                    .orElseThrow(() -> new InvalidIDException("Invalid id"));
    }
}

