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
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@AllArgsConstructor@NoArgsConstructor
@Data@Entity
public class Classroom {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @NotEmpty(message = "name is required")
    private String classname;


   @ManyToOne
    @JsonIgnore
    private Teacher teachers;


}
/*@JoinTable(
        name = "student_enroller",
        joinColumns = @JoinColumn(name = "s_id"),
        inverseJoinColumns = @JoinColumn(name = "class_id")
)*/