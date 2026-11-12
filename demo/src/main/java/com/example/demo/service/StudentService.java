package com.example.demo.service;

import com.example.demo.dtos.AddressDto;
import com.example.demo.dtos.StudentDetailsResponseDto;
import com.example.demo.dtos.StudentDto;

import java.util.List;

public interface StudentService{

    StudentDto createStudentDto(StudentDto student);

    AddressDto addAddress(AddressDto addressDto);

    List<StudentDetailsResponseDto> getStudentDetails(Integer studentId);




}
