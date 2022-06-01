package com.example.w3d04exer.model.ManyToMany;

import com.example.w3d04exer.model.ManyToOne.Classroom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Generated;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Student {


    @Id
    //@NotNull(message = "id is required")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "name isr required")
    private String name;
    @NotEmpty(message = "age isr required")
    private String age ;
    @NotEmpty(message = "major isr required")
    private String major;

    @ManyToMany(mappedBy = "students")
    @JsonIgnore
    private Set<Classroom> classrooms;



}
