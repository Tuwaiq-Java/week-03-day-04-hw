package com.example.schoolmanagementsoftware.repository;

import com.example.schoolmanagementsoftware.model.ModelStudent;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface StudentRepository extends JpaRepository <ModelStudent,Integer>

{


    }

