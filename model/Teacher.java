package com.example.schoolmmanagement.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Teacher {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @NotNull(message = "your id is required")
    private Long id;
    @NotEmpty(message = "your name is required")
    @Column(unique = true,nullable = false)
    private String name;


    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;
}
