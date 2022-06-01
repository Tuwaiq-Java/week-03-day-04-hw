package com.example.w3d04exer.repository;

import com.example.w3d04exer.model.ManyToOne.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher,Integer> {
}
