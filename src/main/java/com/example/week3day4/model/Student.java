package com.example.week3day4.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer stu_id;
    @NotEmpty(message = "name is required")
    private String name;
    @NotNull(message = "age is required")
    private Integer age;
    @NotEmpty(message = "major is required")
    private String major;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ClassRoom>Classes;


}
