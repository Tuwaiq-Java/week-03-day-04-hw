package com.example.schoolmanagementsoftware2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer sId;
    @NotEmpty(message = "Name is required")
    private String name;
    @NotEmpty(message = "Name is required")
    private Integer age;
    @NotEmpty(message = "Name is required")
    private String major;

    @ManyToMany(mappedBy = "students", cascade = CascadeType.ALL)
    private Set<Classroom> classroomSet;
}