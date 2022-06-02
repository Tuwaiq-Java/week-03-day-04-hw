package com.example.schoolmanagementsoftware.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class ModelClass {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @NotEmpty(message = "id is required")
    private String idClass ;
    //----------------------------
    @NotEmpty(message = "name is required")
    private String nameClass ;
//-------------------------------------------------------------------------
    //Relation

    @ManyToMany(mappedBy = "modelclass",cascade = CascadeType.ALL)
    @JsonIgnore
    private Set<ModelStudent> students;

    @OneToMany(mappedBy = "modelclass",cascade = CascadeType.ALL)
    private Set<ModelClass> modelClasses;



}
