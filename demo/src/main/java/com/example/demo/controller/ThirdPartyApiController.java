package com.example.demo.controller;

import com.example.demo.ServiceImple.WeatherServiceImpl;
import com.example.demo.dtos.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ThirdPartyApiController {


    @Autowired
    private WeatherServiceImpl weatherService;

    @GetMapping("/v1/weatherChek")
   public ResponseEntity<WeatherDto> checkWeather(@RequestParam String query){

        ResponseEntity<WeatherDto> weather = weatherService.getWeather(query);

        return weather;

    }




}
