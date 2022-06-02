package com.example.d4studentrelations.DTO;


import com.example.d4studentrelations.Models.Classroom;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;



@Data
@AllArgsConstructor

public class StudentDTO {

    private Integer classid;

    private String name;

    private String  age;

    private String  major;



}
