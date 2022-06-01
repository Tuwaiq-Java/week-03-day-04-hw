package com.example.w3d04exer.model.ManyToOne;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Teacher {
    @Id
    //@NotNull
    @GeneratedValue(strategy = GenerationType.AUTO)

    private Integer id;
    private String name ;


    @OneToMany(mappedBy = "teacher")
    private Set<Classroom> classrooms;
}
