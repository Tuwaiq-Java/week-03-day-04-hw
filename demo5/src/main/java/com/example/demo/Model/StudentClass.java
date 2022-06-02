package com.example.demo.Model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class StudentClass {
    @Id
    @NotNull(message = "Write a id !")
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(unique = true)
    private Integer id;
    @NotEmpty(message = "Write a name !")
    private String name;
    @NotNull(message = "Write an age !")
    private  Integer age;
    @NotEmpty(message = "Write a major ! ")
    private String major;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ClassRoom> classRoom;
}
