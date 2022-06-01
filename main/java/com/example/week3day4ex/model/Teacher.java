package com.example.week3day4ex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is required") @Column(unique = true)
    private String name;

    @OneToMany(mappedBy = "teacher", cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;
}
