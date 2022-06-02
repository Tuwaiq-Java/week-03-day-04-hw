package com.example.schoolmanagementsoftware.service;

import com.example.schoolmanagementsoftware.model.ModelClass;
import com.example.schoolmanagementsoftware.repository.ClassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor

public class ClassService {
    private final ClassRepository classRepository;


    public List<ModelClass> getClasses() {

        return classRepository.findAll();

    }


    public void addClass(ModelClass modelClass) {
        classRepository.save(modelClass);

    }

    public List<ModelClass> takesclass(Integer id) {
        return classRepository.findAll();

    }

    public void takesclassid(ModelClass classid) {
        classid = classRepository.findById(classid)
                .orElseThrow(
                        ()->new InvalidIdException("Invalid id"));
    }
    }

