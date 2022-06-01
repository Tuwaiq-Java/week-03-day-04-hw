package com.example.school.service;

import com.example.school.model.Classroom;
import com.example.school.model.Student;
import com.example.school.model.Teacher;
import com.example.school.repositroy.ClassRoomRepository;
import com.example.school.repositroy.StudentRepository;
import com.example.school.repositroy.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.*;

@Service
@RequiredArgsConstructor
public class ClassRoomService {
    private final ClassRoomRepository classRoomRepository;
    private final StudentRepository studentRepository;
    private final TeacherRepository teacherRepository;


    public List<Classroom> getClassRoom() {
        return classRoomRepository.findAll();
    }

    public void checkClassRoomById(Integer id) {
        classRoomRepository.findById(id).get();
    }

    public void addClassRoom(Classroom classroom){
        classRoomRepository.save(classroom);
    }
    /*

    public List<Student> getStudentOfclass(Integer classId) {
        return classRoomRepository.findAllStudentByClassId(classId).get();
    }
*/
    public void addStudentToClass(Integer classId, Integer studentId) {
        Classroom classroom = this.classRoomRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("class not found"));
        Student student = this.studentRepository.findById(studentId)
                .orElseThrow(() -> new RuntimeException("student not found"));
        if(CollectionUtils.isEmpty(student.getClassrooms())) {
            student.setClassrooms(new HashSet<>());
        }
        student.getClassrooms().add(classroom);
        studentRepository.save(student);
    }
    public void addTeacherToClass(Integer classId, Integer teacherId) {
        Classroom classroom = this.classRoomRepository.findById(classId)
                .orElseThrow(() -> new RuntimeException("class not found"));
       Teacher teacher= this.teacherRepository.findById(teacherId)
                .orElseThrow(() -> new RuntimeException("Teacher not found"));
        if(CollectionUtils.isEmpty(teacher.getClass_t())) {
           teacher.setClass_t(new HashSet<>());
        }
        teacher.getClass_t().add(classroom);
        teacherRepository.save(teacher);
    }
}
