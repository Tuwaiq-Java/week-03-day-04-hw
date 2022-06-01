package com.example.useradviceexample0304.repository;

import com.example.useradviceexample0304.models.Classroom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassroomRepository extends JpaRepository<Classroom,Integer> {
}
