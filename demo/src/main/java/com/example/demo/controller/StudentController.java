package com.example.demo.controller;

import com.example.demo.dtos.AddressDto;
import com.example.demo.dtos.StudentDetailsResponseDto;
import com.example.demo.dtos.StudentDto;
import com.example.demo.exceptionclasss.MyCustomException;
import com.example.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class StudentController {

    @Autowired
    StudentService service;

    @PostMapping("/createStudent")
    public ResponseEntity<StudentDto> createStudent(@RequestBody StudentDto student) {

        StudentDto response = service.createStudentDto(student);

        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/addAddress")
    public ResponseEntity<AddressDto> addAddress(@RequestBody AddressDto addressDto) {

        AddressDto addressDto1 = service.addAddress(addressDto);

        return new ResponseEntity<>(addressDto1, HttpStatus.CREATED);

    }


    @GetMapping("/getStudentDetails/{studentId}")
    public ResponseEntity<String> getStudentDetails(@PathVariable Integer studentId) throws MyCustomException {

        if (studentId == 0) {
            throw new MyCustomException(HttpStatus.BAD_REQUEST, "Student  id not found");
        } else {
            System.out.println("student found");
        }

        return ResponseEntity.status(HttpStatus.OK).body("Student Found");


    }

}