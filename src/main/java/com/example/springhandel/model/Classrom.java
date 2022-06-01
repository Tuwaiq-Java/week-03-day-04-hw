package com.example.springhandel.model;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Classrom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message ="name:Should be not empty")
    private String name;

    @ManyToMany(cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student>students;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

}
