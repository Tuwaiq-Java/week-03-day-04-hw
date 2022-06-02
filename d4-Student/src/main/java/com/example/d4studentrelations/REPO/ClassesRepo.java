package com.example.d4studentrelations.REPO;

import com.example.d4studentrelations.Models.Classroom;
import com.example.d4studentrelations.Models.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassesRepo extends JpaRepository<Classroom,Integer> {

    Classroom findClassroomById(Integer classid);

}
