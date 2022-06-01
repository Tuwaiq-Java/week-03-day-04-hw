package com.example.week3day4ex.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.Value;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is required") @Column(unique = true)
    private String name;
    @NotNull(message = "Age is required")
    private Integer age;
    @NotEmpty(message = "Major is required")
    private String major;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;

}
