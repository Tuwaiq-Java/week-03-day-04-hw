package com.example.w3d04exer.repository;

import com.example.w3d04exer.model.ManyToMany.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {



}
