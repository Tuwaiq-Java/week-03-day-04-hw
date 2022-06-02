package com.example.d4studentrelations.Models;


import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Setter @Getter
@Valid
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Teacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @NotEmpty(message = "Name should not be empty")
    private String name;


    @OneToMany(mappedBy = "teacher",cascade = CascadeType.ALL)
    private Set<Classroom> classroomSet;

}
