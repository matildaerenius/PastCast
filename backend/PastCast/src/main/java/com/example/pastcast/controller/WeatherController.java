package com.example.pastcast.controller;

import com.example.pastcast.model.Weather;
import com.example.pastcast.service.WeatherService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class WeatherController {

    private final WeatherService weatherService;

    // Injektionskonstruktor
    public WeatherController(WeatherService weatherService) {
        this.weatherService = weatherService;
    }

    // REST-endpoint för att hämta väderdata
    @GetMapping("/weather/{location}")
    public Weather getWeather(@PathVariable String location) {
        return weatherService.getWeatherFromApi(location);
    }
}
