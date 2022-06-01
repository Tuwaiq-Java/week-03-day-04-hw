package com.example.useradviceexample0304.models;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany(mappedBy = "classrooms")
    @JsonIgnore
    private Set<Student> students;


    public Classroom(Object o, String name, Teacher teacher) {
    }
}
