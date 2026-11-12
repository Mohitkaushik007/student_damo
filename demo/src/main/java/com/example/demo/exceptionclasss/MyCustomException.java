package com.example.demo.exceptionclasss;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MyCustomException extends Exception{

    public MyCustomException(String message) {
        super(message);

    }


    public MyCustomException(HttpStatus status, String message) {
        super(message);

    }






}
