package com.example.schoolmanagementsoftware2.Repository;

import com.example.schoolmanagementsoftware2.Model.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRepository extends JpaRepository<Teacher, Integer> {
}