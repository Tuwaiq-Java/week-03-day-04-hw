package com.example.w3d4exer.services;

import com.example.w3d4exer.DTO.ClassDTO;
import com.example.w3d4exer.Repository.Classroomrepo;
import com.example.w3d4exer.Repository.Studentrepo;
import com.example.w3d4exer.Repository.Teacherrepo;
import com.example.w3d4exer.exeptions.InvalidId;
import com.example.w3d4exer.model.Classroom;
import com.example.w3d4exer.model.Students;
import com.example.w3d4exer.model.Teacher;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class Classroomservice {

    private final Classroomrepo classroomrepo;
    private final Teacherrepo teacherrepo;

    public List<Classroom> getClassroom(){
        return classroomrepo.findAll();
    }
    public Classroom getClassroomById(Integer id){
        return classroomrepo.findById(id).get();
    }

   /* public ResponseEntity addClassroom(ClassDTO classdto)throws IllegalAccessException{
        Teacher teacher=teacherrepo.findById(classdto.getTeacherId()).get();
        Classroom classroom=new Classroom(teacher.getId(),classdto.getName(),teacher,null);
        teacher.getClassrooms().add(classroom);
        classroomrepo.save(classroom);
        classroomrepo.save(classroom);
        return ResponseEntity.status(HttpStatus.OK).body(classroomrepo.findAll());


    }*/
    public ResponseEntity addClassroom(Integer idt,Classroom classroom1)throws IllegalAccessException{

        Teacher teacher =teacherrepo.findById(idt).get();
        Classroom classroom=new Classroom(classroom1.getId(),classroom1.getName(),teacher,null);
        teacher.getClassrooms().add(classroom);
        classroomrepo.save(classroom);
        return ResponseEntity.status(200).body(classroomrepo.findAll());
    }


    public void checkClassroomid(Integer id) {
            Classroom classroom=classroomrepo.findById(id)
                    .orElseThrow(
                            ()->new InvalidId("Invalid id"));
    }
}
