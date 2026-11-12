package com.example.demo.ServiceImple;

import com.example.demo.dtos.WeatherDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherServiceImpl {

    private  String apikey = "b8cccfd41cc22a87ec43b4177cd9fd0a";

    private  String Api = "http://api.weatherstack.com/current?access_key=YOUR_ACCESS_KEY&query=NewYork";

    @Autowired
     RestTemplate restTemplate;

   public ResponseEntity<WeatherDto> getWeather(String city){

        String finalApi = Api.replace("YOUR_ACCESS_KEY",apikey).replace("NewYork",city);

       ResponseEntity<WeatherDto> exchange = restTemplate.exchange(finalApi, HttpMethod.GET, null, WeatherDto.class);

       if(exchange != null ){
           return exchange;
       }

      return new ResponseEntity<>(new WeatherDto(),HttpStatus.NO_CONTENT);

   }


}
