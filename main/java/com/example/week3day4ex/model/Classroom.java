package com.example.week3day4ex.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data @Entity
public class Classroom {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @NotEmpty(message = "Name is required") @Column(unique = true)
    private String name;


    @ManyToMany(mappedBy = "classrooms",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> students;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

}
