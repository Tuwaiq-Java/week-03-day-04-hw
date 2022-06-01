package com.example.schoolmanagementsoftware2.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Classroom {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer cId;
    @NotEmpty(message = "Name is required")
    private String name;


    @ManyToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "studentId")
    @JsonIgnore
    private Set<Student> students;

    @ManyToOne
    @JoinColumn(name = "teacherId")
    @JsonIgnore
    private Teacher teachers;
}