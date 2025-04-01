package com.example.pastcast.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "weather_data")
public class Weather {

    @Id
    private String id;
    private String location;
    private String description;
    private double temperature;
    private double humidity;
    private double windSpeed;
    private String date;
}
