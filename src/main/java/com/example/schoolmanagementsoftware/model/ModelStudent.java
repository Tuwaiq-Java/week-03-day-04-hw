package com.example.schoolmanagementsoftware.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Set;

@AllArgsConstructor@NoArgsConstructor@Data
@Entity
public class ModelStudent {
    @Id
    //@GeneratedValue(strategy = GenerationType.AUTO)

    @NotEmpty(message = "id is required")
    private String id ;
    //----------------------------
    @NotEmpty(message = "name is required")
    private String name ;
    //--------------------------------------
    @NotNull(message = "AGE  is required")
    private Integer age ;
    //--------------------------------
    @NotEmpty(message = "major is required")
    private String major ;


    @ManyToMany(cascade = CascadeType.ALL)
    private Set<ModelClass> modelClasses;
}

