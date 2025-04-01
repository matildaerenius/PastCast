package com.example.pastcast.service;


import com.example.pastcast.model.Weather;
import com.example.pastcast.repository.WeatherRepository;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class WeatherService {

    private final WeatherRepository weatherRepository;
    private final RestTemplate restTemplate;

    @Value("${openweathermap.api.key}")
    private String apiKey;


    public WeatherService(WeatherRepository weatherRepository) {
        this.weatherRepository = weatherRepository;
        this.restTemplate = new RestTemplate();
    }

    /*
    OpenWeatherMap
    WeatherStack
    Open-Meteo
    Tomorrow.io (Climacell)
    WeatherAPI
    AccuWeather
     */

    public Weather getWeatherFromApi(String location) {
        // ändra till nyckel

        String apiUrl = "https://api.openweathermap.org/data/2.5/weather?q=" + location + "&appid=" + apiKey + "&units=metric";

        // Hämta JSON-responsen från API
        String response = restTemplate.getForObject(apiUrl, String.class);

        // Parse JSON och skapa ett Weather-objekt
        Weather weather = parseWeatherResponse(response);

        return weatherRepository.save(weather);
    }

    private Weather parseWeatherResponse(String response) {

        // exempel, hårdkodad väderdata (denna kod kan förbättras med JSON parsing)

        Weather weather = new Weather();
        weather.setLocation("ExampleLocation");
        weather.setDescription("Clear sky");
        weather.setTemperature(25.0);
        weather.setHumidity(60.0);
        weather.setWindSpeed(10.0);
        weather.setDate("2025-04-01");

        return weather;
    }
}

