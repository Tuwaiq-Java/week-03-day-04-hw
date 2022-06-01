package com.example.school.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

@AllArgsConstructor@NoArgsConstructor
@Data
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    @NotEmpty(message = "name is required")
    private String studentname;
    @NotNull(message = "age is required")
    private  Integer age;
    @NotEmpty(message = " major name is required")
    private String major;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;


}
