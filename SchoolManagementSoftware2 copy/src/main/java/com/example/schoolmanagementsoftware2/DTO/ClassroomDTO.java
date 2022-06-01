package com.example.schoolmanagementsoftware2.DTO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor @NoArgsConstructor @Data
public class ClassroomDTO {

    private Integer tId;
    private Integer sId;
    private String tName;
    private String sName;
    private Integer age;
    private String major;
}