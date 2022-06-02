package com.example.demo.Model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@Setter @Getter
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class ClassRoom {
    @Id
    @NotNull(message = "Write a id For the Class !")
    private Integer id;
    @NotEmpty(message = "Write a Name The Class !")
    private String name;




    @ManyToOne
    @JsonIgnore
    private Teacher teacher;





}
