package com.example.w3d4exer.Repository;

import com.example.w3d4exer.model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Teacherrepo extends JpaRepository<Teacher,Integer> {

}
