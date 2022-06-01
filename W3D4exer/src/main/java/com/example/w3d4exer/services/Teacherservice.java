package com.example.w3d4exer.services;

import com.example.w3d4exer.Repository.Classroomrepo;
import com.example.w3d4exer.Repository.Teacherrepo;
import com.example.w3d4exer.exeptions.InvalidId;
import com.example.w3d4exer.model.Classroom;
import com.example.w3d4exer.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Teacherservice {

    private final Teacherrepo teacherrepo;

    public List<Teacher> getTeacher(){
        return teacherrepo.findAll();
    }
    public Teacher getTeacherById(Integer id){
        return teacherrepo.findById(id).get();
    }

    public void addTeacher(Teacher teacher){
        teacherrepo.save(teacher);
    }

    public void checkTeacherid(Integer id) {
        Teacher teacher=teacherrepo.findById(id)
                .orElseThrow(
                        ()->new InvalidId("Invalid id"));
    }
}
