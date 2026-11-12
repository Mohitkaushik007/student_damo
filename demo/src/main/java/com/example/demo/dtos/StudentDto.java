package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class StudentDto {

    private Integer studentId;
    private String name;
    private String email;


    @JsonFormat(pattern = "dd/mm/yyyy")
    private Date dateOfBirth;
}
