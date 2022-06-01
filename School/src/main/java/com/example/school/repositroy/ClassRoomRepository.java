package com.example.school.repositroy;

import com.example.school.model.Classroom;
import com.example.school.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ClassRoomRepository extends JpaRepository<Classroom,Integer> {
  //  @Query("select distinct s from  Student s join s.classrooms sc where  sc.id = :id  ")
   // Optional<List<Student>> findAllStudentByClassId(Integer classId);
}
