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

public class Classroom {

    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should not be empty")
    private String name;



    @ManyToOne
    @JoinColumn(name = "teacher_id")
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany
    @JoinColumn(name = "student_id")
    private Set<Student> studentSet;


}

