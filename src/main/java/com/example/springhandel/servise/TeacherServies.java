package com.example.springhandel.servise;

import com.example.springhandel.exceptions.InvalidException;
import com.example.springhandel.model.Classrom;
import com.example.springhandel.model.Student;
import com.example.springhandel.model.Teacher;
import com.example.springhandel.repoistory.ClassRoomRepoistory;
import com.example.springhandel.repoistory.StudentRepoistory;
import com.example.springhandel.repoistory.TeacherRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TeacherServies {

    private final TeacherRepoistory teacherRepoistory;
    private final ClassRoomRepoistory classRoomRepoistory;


    public List<Teacher>getAllTeacher(){

        return teacherRepoistory.findAll();
    }
    public void addTeacher(Teacher teacher){
        teacherRepoistory.save(teacher);

    }

    public Teacher getOneTeacher(Integer id){

        return teacherRepoistory.findById(id).get();
    }

    public void enrooledTeacherToClass(Integer tech_id,Integer class_id){
        Optional<Teacher> teacher=teacherRepoistory.findById(tech_id);
        if(teacher.isEmpty()){
            throw new InvalidException("Teacher id invalied");
        }
        Optional<Classrom> course=classRoomRepoistory.findById(class_id);
        if(course.isEmpty()){
            throw new InvalidException("Class id invailed ");
        }
        teacher.get().getClasses().add(course.get());
        teacherRepoistory.save(teacher.get());

    }
}
