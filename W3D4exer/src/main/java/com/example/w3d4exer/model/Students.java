package com.example.w3d4exer.model;

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
public class Students {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@NotNull (message = "id is required..")
    private Integer id;
    @NotEmpty (message = "name is required..")
    private String name;
    @NotNull (message = "age is required..")
    private Integer aga;
    @NotEmpty (message = "major is required..")
    private String major;

   @ManyToMany(cascade = CascadeType.ALL)

    private Set<Classroom> classrooms;








}
