package com.example.springhandel.repoistory;

import com.example.springhandel.model.Classrom;
import com.example.springhandel.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClassRoomRepoistory extends JpaRepository<Classrom,Integer> {

}
