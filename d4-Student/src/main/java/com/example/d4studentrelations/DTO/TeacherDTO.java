package com.example.d4studentrelations.DTO;


import com.example.d4studentrelations.Models.Classroom;
import lombok.*;

import javax.persistence.*;
import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.Set;

@Data
@AllArgsConstructor

public class TeacherDTO {


    private Integer classid;

    private String name;


}
