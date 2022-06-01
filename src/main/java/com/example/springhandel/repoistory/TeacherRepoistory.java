package com.example.springhandel.repoistory;

import com.example.springhandel.model.Student;
import com.example.springhandel.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepoistory extends JpaRepository<Teacher,Integer> {

}

