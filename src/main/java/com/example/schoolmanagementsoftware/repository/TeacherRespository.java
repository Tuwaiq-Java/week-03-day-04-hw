package com.example.schoolmanagementsoftware.repository;

import com.example.schoolmanagementsoftware.model.ModelTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TeacherRespository extends JpaRepository<ModelTeacher,Integer> {
}
