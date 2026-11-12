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
@Getter
@Setter
public class AddressDto {
    private Integer addressId;
    private Integer studentId;
    private AddressType addressType;
    private String street;
    private Integer pincode;
}
