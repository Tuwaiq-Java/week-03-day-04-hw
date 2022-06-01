package com.example.week3day4.service;

import com.example.week3day4.exception.InvalidIDException;
import com.example.week3day4.model.ClassRoom;
import com.example.week3day4.model.Teacher;
import com.example.week3day4.repository.ClassRoomRepository;
import com.example.week3day4.repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class TeacherService {

    private final TeacherRepository teacherRepository;
    private final ClassRoomRepository classRoomRepository;
    public List<Teacher> getTeachers(){
        return teacherRepository.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepository.save(teacher);
    }
    public Teacher getTeacher(Integer tech_id){
        Optional<Teacher> teacher=teacherRepository.findById(tech_id);
        if(teacher.isEmpty()){
            throw new InvalidIDException("Invalid Teacher ID");
        }
        return teacher.get();
    }
    public void assignTeacherToClass(Integer tech_id,Integer class_id){
        Optional<Teacher>teacher=teacherRepository.findById(tech_id);
        if(teacher.isEmpty()){
            throw new InvalidIDException("Teacher not found");
        }
        Optional<ClassRoom> course=classRoomRepository.findById(class_id);
        if(course.isEmpty()){
            throw new InvalidIDException("Class not found");
        }
        teacher.get().getClasses().add(course.get());
       teacherRepository.save(teacher.get());

    }
}
