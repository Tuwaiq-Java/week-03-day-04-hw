package com.example.schoolmanagementsoftware2.Model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
@ToString
public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer tId;
    @NotEmpty(message = "Name is required")
    private String name;


    @OneToMany(mappedBy = "teachers", cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;

}