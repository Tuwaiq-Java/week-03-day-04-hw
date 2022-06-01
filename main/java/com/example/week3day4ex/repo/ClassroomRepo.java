package com.example.week3day4ex.repo;

import com.example.week3day4ex.model.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepo extends JpaRepository<Classroom,Integer> {
}
