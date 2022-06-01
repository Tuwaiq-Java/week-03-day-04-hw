package com.example.w3d4exer.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Data
@Entity
public class Teacher {
    @Id
    @NotNull(message = "id is required..")
    private Integer id;
    @NotEmpty(message = "name is required..")
    private String name;

@OneToMany(mappedBy ="teachers",cascade = CascadeType.ALL)
    private Set<Classroom> classrooms;

}
