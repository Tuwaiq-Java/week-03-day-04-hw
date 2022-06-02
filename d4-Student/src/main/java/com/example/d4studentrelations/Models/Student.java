package com.example.d4studentrelations.Models;


import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Setter
@Getter
@Valid
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should not be empty")
    private String name;

    @NotEmpty(message = "age should not be empty")
    private String  age;

    @NotEmpty(message = "major should not be empty")
    private String  major;


    @ManyToMany(mappedBy = "studentSet", cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;


}
