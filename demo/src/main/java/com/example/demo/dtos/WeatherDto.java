package com.example.demo.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class WeatherDto {

    private Request request;
    private Location location;
    private Current current;
}



@Setter
@Getter
 class Request{
    public String type;
    public String query;
    public String language;
    public String unit;
}


@Setter
@Getter
class Location{
    public String name;
    public String country;
    public String region;
    public String lat;
    public String lon;
    @JsonProperty("timezone_id")
    public String timezoneId;
    public String localtime;
    @JsonProperty("timezone_epoch")
    public int localZoneEpoch;
    @JsonProperty("utc_offset")
    public String utcOffset;
}



@Setter
@Getter
class Current{
    @JsonProperty("observation_time")
    public String observationTime;
    public int temperature;
    @JsonProperty("weather_code")
    public int weatherCode;
    @JsonProperty("wind_speed")
    public int windSpeed;
    @JsonProperty("wind_degree")
    public int windDegree;
    @JsonProperty("wind_dir")
    public String windDir;
    public int pressure;
    public int precip;
    public int humidity;
    public int cloudcover;
    public int feelslike;
    @JsonProperty("uv_index")
    public int uvIndex;
    public int visibility;
}
