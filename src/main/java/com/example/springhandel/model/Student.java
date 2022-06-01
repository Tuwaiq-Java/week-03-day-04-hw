package com.example.springhandel.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message ="name:Should be not empty")


    private String name;
    @NotNull(message ="age:Should be not empty")

    private Integer age;

    @NotEmpty(message ="major:Should be not empty")

    private String major;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Classrom>classrooms;
}

