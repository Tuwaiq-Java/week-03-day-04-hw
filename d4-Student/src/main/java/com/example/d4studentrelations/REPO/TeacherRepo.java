package com.example.d4studentrelations.REPO;

import com.example.d4studentrelations.Models.Student;
import com.example.d4studentrelations.Models.Teacher;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TeacherRepo extends JpaRepository<Teacher,Integer> {


    Teacher findTeacherById(Integer teacherid);
}
