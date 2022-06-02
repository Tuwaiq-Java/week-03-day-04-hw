package com.example.d4studentrelations.REPO;

import com.example.d4studentrelations.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StudentRepo extends JpaRepository<Student,Integer> {

Student findStudentById(Integer studentid);

}
