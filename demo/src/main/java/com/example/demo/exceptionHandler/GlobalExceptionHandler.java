package com.example.demo.exceptionHandler;

import com.example.demo.exceptionclasss.MyCustomException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {


    @ExceptionHandler(MyCustomException.class)
    public ResponseEntity<String> handleSystemException(MyCustomException systemException) {
        log.error(systemException.getMessage());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(systemException.getMessage());
    }




}
