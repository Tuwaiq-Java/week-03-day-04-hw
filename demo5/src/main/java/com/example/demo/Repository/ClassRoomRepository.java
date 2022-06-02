package com.example.demo.Repository;

import com.example.demo.Model.ClassRoom;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassRoomRepository extends JpaRepository <ClassRoom,Integer> {
}
