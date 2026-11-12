package com.example.demo.dtos;

import com.example.demo.enums.AddressType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class StudentDetailsResponseDto {
    private Integer addressId;
    private Integer studentId;
    @Enumerated(EnumType.STRING)
    private AddressType addressType;
    private String street;
    private Integer pincode;
    private String name;
    private  String email;
}
