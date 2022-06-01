package com.example.schoolmanagementsoftware2.Repository;

import com.example.schoolmanagementsoftware2.Model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom, Integer> {
}