package com.example.d4studentrelations.DTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.validation.constraints.NotEmpty;
@AllArgsConstructor @NoArgsConstructor
@Setter @Getter
public class ClassroomDTO {

    private Integer teacherid;
    private Integer studentid;
    private String name;


}
