package com.example.useradviceexample0304.models;

import lombok.*;
import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor @NoArgsConstructor @Setter @Getter
@Entity
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @NotNull
    private String name;
    @NotNull
    private Integer age;
    @NotNull
    private String major;

    @ManyToMany()
    private Set<Classroom> classrooms;

}
