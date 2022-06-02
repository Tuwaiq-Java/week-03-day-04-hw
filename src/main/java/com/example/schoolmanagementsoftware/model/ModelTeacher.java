package com.example.schoolmanagementsoftware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ModelTeacher {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @NotEmpty(message = "id is required")
    private String idTeacher;
    //----------------------------
    @NotEmpty(message = "name is required")
    private String nameTeacher;


    @ManyToOne
    @JsonIgnore
    private ModelClass modelClass;


}





