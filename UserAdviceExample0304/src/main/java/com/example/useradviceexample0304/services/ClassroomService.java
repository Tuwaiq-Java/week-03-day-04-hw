package com.example.useradviceexample0304.services;


import com.example.useradviceexample0304.DTO.ClassroomDTO;
import com.example.useradviceexample0304.models.Classroom;
import com.example.useradviceexample0304.models.Teacher;
import com.example.useradviceexample0304.repository.ClassroomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service @RequiredArgsConstructor
public class ClassroomService {
    private final ClassroomRepository classroomRepository;
    private final TeacherService teacherService;
    public List getClassrooms(){
            return classroomRepository.findAll();
    }
    public void addClassroom(Classroom classroom){
        classroomRepository.save(classroom);
    }

    public Classroom findClassById(Integer classId) {
        return classroomRepository.findById(classId).get();
    }
    public void addTeacherToClass(ClassroomDTO classroomDTO){
        Teacher teacher = teacherService.findTeacherById(classroomDTO.getTeacherId());
        Classroom classroom = new Classroom(null,classroomDTO.getName(), teacher);
        teacher.getRooms().add(classroom);
        classroomRepository.save(classroom);
    }
}
