package com.example.springhandel.servise;

import com.example.springhandel.exceptions.InvalidException;
import com.example.springhandel.model.Classrom;
import com.example.springhandel.model.Student;
import com.example.springhandel.repoistory.ClassRoomRepoistory;
import com.example.springhandel.repoistory.StudentRepoistory;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class StudentServies {

    private final StudentRepoistory studentRepoistory;
    private final ClassRoomRepoistory classRoomRepoistory;


    public List<Student> getAllStudent() {

        return studentRepoistory.findAll();
    }

    public void addStudent(Student student) {
        studentRepoistory.save(student);

    }

    public Student getOneStudent(Integer id) {

        return studentRepoistory.findById(id).orElseThrow(()->{
            throw new InvalidException("Student id is invaild!");
        });




    }
    public void enrollStudentToClass(Integer class_id,Integer stu_id){
        Optional<Student>student=studentRepoistory.findById(stu_id);
        if(student.isEmpty()){
            throw new InvalidException("Student id invailed ");
        }
        Optional<Classrom> subject=classRoomRepoistory.findById(class_id);
        if(subject.isEmpty()){
            throw new InvalidException("Class id invaoled");
        }
        student.get().getClassrooms().add(subject.get());
        studentRepoistory.save(student.get());

    }


}
