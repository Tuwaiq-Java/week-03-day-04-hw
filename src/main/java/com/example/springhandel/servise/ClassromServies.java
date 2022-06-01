package com.example.springhandel.servise;

import com.example.springhandel.model.Classrom;
import com.example.springhandel.model.Teacher;
import com.example.springhandel.repoistory.ClassRoomRepoistory;
import com.example.springhandel.repoistory.TeacherRepoistory;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClassromServies {

    private final ClassRoomRepoistory classRoomRepoistory;


    public List<Classrom>getAllClassRoom(){

        return classRoomRepoistory.findAll();
    }
    public void addClassRoom(Classrom classrom){
       classRoomRepoistory.save(classrom);

    }

    public Classrom getOneClassRoom(Integer id){

        return classRoomRepoistory.findById(id).get();
    }

}
