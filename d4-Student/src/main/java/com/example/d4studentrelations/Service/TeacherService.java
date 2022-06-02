package com.example.d4studentrelations.Service;

import com.example.d4studentrelations.Models.Classroom;
import com.example.d4studentrelations.Models.Teacher;
import com.example.d4studentrelations.REPO.ClassesRepo;
import com.example.d4studentrelations.REPO.TeacherRepo;
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


    public void addTeacher(Teacher teacher) {
        teacherRepo.save(teacher);

    }


    public Teacher OneTeacher(Integer teacherid) {

        Teacher target_teacherid =  teacherRepo.findTeacherById(teacherid);
        return target_teacherid;
    }

}
