package com.example.schoolmanagementsoftware2.Repository;

import com.example.schoolmanagementsoftware2.Model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
}