package com.example.schoolmanagementsoftware.repository;

import com.example.schoolmanagementsoftware.model.ModelClass;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface ClassRepository  extends JpaRepository< ModelClass,Integer>{

}
