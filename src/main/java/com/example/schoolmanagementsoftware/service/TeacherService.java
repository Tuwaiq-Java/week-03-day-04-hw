package com.example.schoolmanagementsoftware.service;

import com.example.schoolmanagementsoftware.model.ModelStudent;
import com.example.schoolmanagementsoftware.model.ModelTeacher;
import com.example.schoolmanagementsoftware.repository.TeacherRespository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
@Service @RequiredArgsConstructor
public class TeacherService {
    private final TeacherRespository teacherRespository;
    public List<ModelTeacher> getTeacher() {
        return teacherRespository.findAll();
    }

    public void addTecher(ModelTeacher teacher) {
        teacherRespository.save(teacher);

    }

    public List<ModelTeacher> takesTeacher(Integer id) {
        return teacherRespository.findAll();

    }

    public void takesstudentid(ModelStudent techearid) {
        techearid = teacherRespository.findById(techearid)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
    }
    }
}
