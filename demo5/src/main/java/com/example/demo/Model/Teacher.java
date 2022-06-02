package com.example.demo.Model;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity

public class Teacher {
    @Id
    @NotNull(message = "Write a id !")
    private Integer id;
    @NotEmpty(message = "Write a Name !")
    private String name;



}
