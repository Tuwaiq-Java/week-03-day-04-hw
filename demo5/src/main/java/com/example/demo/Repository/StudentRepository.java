package com.example.demo.Repository;

import com.example.demo.Model.StudentClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository <StudentClass, Integer> {
}
