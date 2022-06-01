package com.example.springhandel.repoistory;

import com.example.springhandel.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepoistory extends JpaRepository<Student,Integer> {

}
