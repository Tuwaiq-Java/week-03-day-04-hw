package com.example.w3d04exer.model.ManyToOne;


import com.example.w3d04exer.model.ManyToMany.Student;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@AllArgsConstructor @NoArgsConstructor @Data
public class Classroom {

    @Id
    //@NotNull(message = "id is required")
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @NotEmpty(message = "name isr required")
    private String name;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany
    private Set<Student> students;



}
