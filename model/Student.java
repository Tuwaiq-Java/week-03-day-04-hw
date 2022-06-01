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
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @NotNull(message = "your id is required")
    private Long id;
    @NotEmpty(message = "your name is required")
    @Column(unique = true)
    private String name;
    @NotNull(message = "your age is required")
    private Integer age;
    @NotEmpty(message = "your major is required")
    private String major;

    @ManyToMany(cascade = CascadeType.ALL)
    private Set<Classroom> classroom;
}
