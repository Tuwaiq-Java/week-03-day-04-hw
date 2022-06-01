package com.example.schoolmmanagement.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(nullable = false)
    @NotNull(message = "your id is required")
    private Long id;
    @NotEmpty(message = "your name is required")
    @Column(unique = true,nullable = false)
    private String name;

    @ManyToOne
    @JsonIgnore
    private Teacher teacher;

    @ManyToMany(mappedBy = "classroom",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<Student> students;
}
